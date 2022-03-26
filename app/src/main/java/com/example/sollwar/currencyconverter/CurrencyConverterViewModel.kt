package com.example.sollwar.currencyconverter

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.sollwar.currencyconverter.model.Info

class CurrencyConverterViewModel : ViewModel() {
    private var _valuteItemLiveData: LiveData<List<Info>> = CurrencyFetch().fetchCurrency()
    fun valuteItemLiveData(): LiveData<List<Info>> {
        return _valuteItemLiveData
    }
    fun refreshValuteItemLiveData() {
        _valuteItemLiveData = CurrencyFetch().fetchCurrency()
    }

}