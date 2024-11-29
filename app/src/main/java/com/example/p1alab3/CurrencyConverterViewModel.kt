package com.example.p1alab3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CurrencyConverterViewModel: ViewModel() {
    private val conversionModel = ConversionModel()

    private val _conversionResult = MutableLiveData<Double>()
    val conversionResult: LiveData<Double> get() = _conversionResult

    private val exchangeRate = 3.70

    fun convertCurrency(amount: String, conversionType: String) {
        try {
            val amountDouble = amount.toDouble()
            val result = when (conversionType) {
                "De Soles a Dólares" -> conversionModel.convertSolesToDollars(amountDouble, exchangeRate)
                "De Dólares a Soles" -> conversionModel.convertDollarsToSoles(amountDouble, exchangeRate)
                else -> 0.0
            }
            _conversionResult.value = result
        } catch (e: NumberFormatException) {
            _conversionResult.value = null
        }
    }
}
