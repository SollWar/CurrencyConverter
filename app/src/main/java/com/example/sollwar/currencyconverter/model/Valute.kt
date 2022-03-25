package com.example.sollwar.currencyconverter.model



data class Valute(
    var AUD: Info,
    var AZN: Info,
    var GBP: Info,
    var AMD: Info,
    var BYN: Info,
    var BGN: Info,
    var BRL: Info,
    var HUF: Info,
    var HKD: Info,
    var DKK: Info,
    var USD: Info,
    var EUR: Info,
    var INR: Info,
    var KZT: Info,
    var CAD: Info,
    var KGS: Info,
    var CNY: Info,
    var MDL: Info,
    var NOK: Info,
    var PLN: Info,
    var RON: Info,
    var XDR: Info,
    var SGD: Info,
    var TJS: Info,
    var TMT: Info,
    var UZS: Info,
    var UAH: Info,
    var CZK: Info,
    var SEK: Info,
    var CHF: Info,
    var ZAR: Info,
    var KRW: Info,
    var JPY: Info,
    var TRY: Info
)

data class Info(
    var ID: String = "",
    var NumCode: String = "",
    var CharCode: String = "",
    var Nominal: String = "",
    var Name: String = "",
    var Value: String = "",
    var Previous: String = ""
)
