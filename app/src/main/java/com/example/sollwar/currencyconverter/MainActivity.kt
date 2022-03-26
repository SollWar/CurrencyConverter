package com.example.sollwar.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sollwar.currencyconverter.fragments.CurrencyConverterFragment
import com.example.sollwar.currencyconverter.fragments.CurrencyListFragment

class MainActivity : AppCompatActivity(), CurrencyListFragment.Callbacks {

    override fun onCurrencySelected(CharCode: String, Value: String) {
        val fragment = CurrencyConverterFragment.newInstance(CharCode, Value)

        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.in_from_right, R.anim.out_to_left, R.anim.in_from_left, R.anim.out_to_right)
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val isFragmentContainerEmpty = savedInstanceState == null
        if (isFragmentContainerEmpty) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, CurrencyListFragment.newInstance())
                .commit()
        }
    }
}