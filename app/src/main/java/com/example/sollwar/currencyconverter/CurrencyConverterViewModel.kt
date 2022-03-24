package com.example.sollwar.currencyconverter

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.sollwar.currencyconverter.model.Info

class CurrencyConverterViewModel : ViewModel() {
    val valuteItemLiveData: LiveData<List<Info>> = CurrencyFetch().fetchCurrency()
}