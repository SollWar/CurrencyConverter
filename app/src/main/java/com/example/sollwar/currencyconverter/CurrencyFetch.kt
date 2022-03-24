package com.example.sollwar.currencyconverter

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sollwar.currencyconverter.api.CbApi
import com.example.sollwar.currencyconverter.model.Info
import com.example.sollwar.currencyconverter.model.ValuteResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "CurrencyFetch"

class CurrencyFetch {
    private val cbApi: CbApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(       "https://www.cbr-xml-daily.ru/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        cbApi = retrofit.create(CbApi::class.java)
    }

    fun fetchCurrency(): LiveData<List<Info>> {
        val responseLiveData: MutableLiveData<List<Info>> = MutableLiveData()
        val cbRequest: Call<ValuteResponse> = cbApi.fetchCurrency()
        cbRequest.enqueue(object : Callback<ValuteResponse> {
            override fun onFailure(call: Call<ValuteResponse>, t: Throwable) {
                Log.e(TAG, "Failed to fetch currency", t)
            }

            override fun onResponse(
                call: Call<ValuteResponse>,
                response: Response<ValuteResponse>
            ) {
                Log.d(TAG, "Response received")
                val valuteResponse: ValuteResponse? = response.body()
                val valuteItem: MutableList<Info> = mutableListOf(
                    valuteResponse?.Valute?.AUD!!,
                    valuteResponse.Valute.AZN,
                    valuteResponse.Valute.GBP,
                    valuteResponse.Valute.AMD,
                    valuteResponse.Valute.BYN,
                    valuteResponse.Valute.BGN,
                    valuteResponse.Valute.BRL,
                    valuteResponse.Valute.HUF,
                    valuteResponse.Valute.HKD,
                    valuteResponse.Valute.DKK,
                    valuteResponse.Valute.USD,
                    valuteResponse.Valute.EUR,
                    valuteResponse.Valute.INR,
                    valuteResponse.Valute.KZT,
                    valuteResponse.Valute.CAD,
                    valuteResponse.Valute.KGS,
                    valuteResponse.Valute.CNY,
                    valuteResponse.Valute.MDL,
                    valuteResponse.Valute.NOK,
                    valuteResponse.Valute.PLN,
                    valuteResponse.Valute.RON,
                    valuteResponse.Valute.XDR,
                    valuteResponse.Valute.SGD,
                    valuteResponse.Valute.TJS,
                    valuteResponse.Valute.TRY,
                    valuteResponse.Valute.TMT,
                    valuteResponse.Valute.UZS,
                    valuteResponse.Valute.UAH,
                    valuteResponse.Valute.CZK,
                    valuteResponse.Valute.KGS,
                    valuteResponse.Valute.CHF,
                    valuteResponse.Valute.ZAR,
                    valuteResponse.Valute.KRW,
                    valuteResponse.Valute.JPY
                )
                Log.d(TAG, valuteResponse.Date)
                responseLiveData.value = valuteItem
            }
        })
        return responseLiveData
    }
}
