package com.example.p1alab3

class ConversionModel {
    fun convertSolesToDollars(soles: Double, exchangeRate: Double): Double {
        return soles * exchangeRate
    }

    fun convertDollarsToSoles(dollars: Double, exchangeRate: Double): Double {
        return dollars / exchangeRate
    }
}
