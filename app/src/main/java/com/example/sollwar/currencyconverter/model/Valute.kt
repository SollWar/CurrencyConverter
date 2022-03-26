package com.example.sollwar.currencyconverter.model



data class Valute(
    var AUD: ValuteInfo,
    var AZN: ValuteInfo,
    var GBP: ValuteInfo,
    var AMD: ValuteInfo,
    var BYN: ValuteInfo,
    var BGN: ValuteInfo,
    var BRL: ValuteInfo,
    var HUF: ValuteInfo,
    var HKD: ValuteInfo,
    var DKK: ValuteInfo,
    var USD: ValuteInfo,
    var EUR: ValuteInfo,
    var INR: ValuteInfo,
    var KZT: ValuteInfo,
    var CAD: ValuteInfo,
    var KGS: ValuteInfo,
    var CNY: ValuteInfo,
    var MDL: ValuteInfo,
    var NOK: ValuteInfo,
    var PLN: ValuteInfo,
    var RON: ValuteInfo,
    var XDR: ValuteInfo,
    var SGD: ValuteInfo,
    var TJS: ValuteInfo,
    var TMT: ValuteInfo,
    var UZS: ValuteInfo,
    var UAH: ValuteInfo,
    var CZK: ValuteInfo,
    var SEK: ValuteInfo,
    var CHF: ValuteInfo,
    var ZAR: ValuteInfo,
    var KRW: ValuteInfo,
    var JPY: ValuteInfo,
    var TRY: ValuteInfo
)

data class ValuteInfo(
    var ID: String = "",
    var NumCode: String = "",
    var CharCode: String = "",
    var Nominal: String = "",
    var Name: String = "",
    var Value: String = "",
    var Previous: String = ""
)
