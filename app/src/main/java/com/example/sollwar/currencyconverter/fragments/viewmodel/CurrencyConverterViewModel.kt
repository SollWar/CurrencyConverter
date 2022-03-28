package com.example.sollwar.currencyconverter.fragments.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.sollwar.currencyconverter.model.ValuteInfo
import com.example.sollwar.currencyconverter.retrofit.CurrencyFetch

class CurrencyConverterViewModel : ViewModel() {
    private var _valuteItemLiveData: LiveData<List<ValuteInfo>> = CurrencyFetch().fetchCurrency()
    fun valuteItemLiveData(): LiveData<List<ValuteInfo>> {
        return _valuteItemLiveData
    }
    fun refreshValuteItemLiveData(): LiveData<List<ValuteInfo>> {
        _valuteItemLiveData = CurrencyFetch().fetchCurrency()
        return _valuteItemLiveData
    }

}