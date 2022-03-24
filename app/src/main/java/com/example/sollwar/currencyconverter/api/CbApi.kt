package com.example.sollwar.currencyconverter.api

import com.example.sollwar.currencyconverter.model.ValuteResponse
import retrofit2.Call
import retrofit2.http.GET

interface CbApi {
    @GET("daily_json.js")
    fun fetchCurrency(): Call<ValuteResponse>
}