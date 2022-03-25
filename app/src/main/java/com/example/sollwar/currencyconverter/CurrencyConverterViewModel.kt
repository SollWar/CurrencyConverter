package com.example.sollwar.currencyconverter

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.sollwar.currencyconverter.model.Info

class CurrencyConverterViewModel : ViewModel() {
    private var valuteItemLiveData: LiveData<List<Info>> = CurrencyFetch().fetchCurrency()
    fun getValuteItemLiveData(): LiveData<List<Info>> {
        return valuteItemLiveData
    }
    fun refreshValuteItemLiveData() {
        valuteItemLiveData = CurrencyFetch().fetchCurrency()
    }

}