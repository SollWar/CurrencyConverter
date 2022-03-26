package com.example.sollwar.currencyconverter.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.sollwar.currencyconverter.CurrencyConverterViewModel
import com.example.sollwar.currencyconverter.R
import com.example.sollwar.currencyconverter.model.Info

class CurrencyListFragment : Fragment() {
    private lateinit var currencyConverterViewModel: CurrencyConverterViewModel
    private lateinit var currencyRecyclerView: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    interface Callbacks { // Интерфейс обратного вызова. Для передачи вызовов из CrimeListFragment в MainActivity
        fun onCurrencySelected(CharCode: String, Value: String)
    }
    private var callbacks: Callbacks? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        currencyConverterViewModel = ViewModelProviders.of(this).get(CurrencyConverterViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_currency_list, container, false)
        currencyRecyclerView = view.findViewById(R.id.currency_recycler_view)
        swipeRefreshLayout = view.findViewById(R.id.refresh_layout)
        currencyRecyclerView.layoutManager = LinearLayoutManager(context)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        swipeRefreshLayout.isRefreshing = true
        currencyConverterViewModel.valuteItemLiveData().observe(
            viewLifecycleOwner,
            Observer { valuteItem ->
                currencyRecyclerView.adapter = ValuteAdapter(valuteItem)
                swipeRefreshLayout.isRefreshing = false
            }
        )
    }

    override fun onStart() {
        super.onStart()
        swipeRefreshLayout.setOnRefreshListener {
            currencyConverterViewModel.refreshValuteItemLiveData()
            swipeRefreshLayout.isRefreshing = false
        }
    }

    private inner class ValuteHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private lateinit var info: Info

        private val charCodeTextView: TextView = itemView.findViewById(R.id.char_code)
        private val nameTextView: TextView = itemView.findViewById(R.id.name)
        private val valueTextView: TextView = itemView.findViewById(R.id.value)
        private val changeTextView: TextView = itemView.findViewById(R.id.changes)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            callbacks?.onCurrencySelected(info.CharCode, info.Value)
        }

        fun bind(info: Info) {
            this.info = info
            charCodeTextView.text = this.info.CharCode
            nameTextView.text = this.info.Name
            valueTextView.text = this.info.Value
            val change = this.info.Value.trim().toFloat() - this.info.Previous.trim().toFloat()
            changeTextView.text = change.toString()
            if (change > 0)
                changeTextView.setTextColor(ContextCompat.getColor(changeTextView.context, R.color.green))
            else changeTextView.setTextColor(ContextCompat.getColor(changeTextView.context, R.color.red));

        }
    }

    private inner class ValuteAdapter(private val valuteItem: List<Info>) : RecyclerView.Adapter<ValuteHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ValuteHolder {
            val view = layoutInflater.inflate(R.layout.item_currency_list, parent, false)
            return ValuteHolder(view)
        }

        override fun onBindViewHolder(holder: ValuteHolder, position: Int) {
            val valuteItem = valuteItem[position]
            holder.apply {
                holder.bind(valuteItem)
            }
        }

        override fun getItemCount(): Int {
            return valuteItem.size
        }
    }

    companion object {
        fun newInstance() : CurrencyListFragment {
            return CurrencyListFragment()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }

}
