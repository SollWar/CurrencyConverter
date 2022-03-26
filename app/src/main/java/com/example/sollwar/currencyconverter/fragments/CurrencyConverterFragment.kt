package com.example.sollwar.currencyconverter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.sollwar.currencyconverter.R

class CurrencyConverterFragment : Fragment() {

    private lateinit var currencyToTextView: TextView
    private lateinit var currencyToEditText: TextView
    private lateinit var currencyFromEditText: EditText
    private var charCode: String? = ""
    private var valueCurrency: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        charCode = arguments?.getString("CharCode")
        valueCurrency = arguments?.getString("Value")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_currency_converter, container, false)
        currencyToTextView = view.findViewById(R.id.currency_to_text_view)
        currencyToEditText = view.findViewById(R.id.currency_to_edit_text)
        currencyFromEditText = view.findViewById(R.id.currency_from_edit_text)
        currencyToTextView.text = charCode
        currencyToEditText.text = ""
        currencyFromEditText.setText("")
        return view
    }

    override fun onStart() {
        super.onStart()
        currencyFromEditText.doAfterTextChanged {
            if (it.toString() != "") {
                val calculate = it.toString().toFloat() / valueCurrency!!.toFloat()
                currencyToEditText.text = calculate.toString()
                currencyFromEditText.error = null
            } else {
                currencyToEditText.text = ""
            }
        }
    }

    companion object {
        fun newInstance(CharCode: String, Value: String): CurrencyConverterFragment {
            val args = Bundle().apply {
                putString("CharCode", CharCode)
                putString("Value", Value)
            }
            return CurrencyConverterFragment().apply {
                arguments = args
            }
        }
    }
}