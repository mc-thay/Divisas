package com.example.p1alab3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CurrencyConverterViewModel
    private lateinit var inputAmount: EditText
    private lateinit var convertButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var conversionTypeSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputAmount = findViewById(R.id.inputSoles)
        convertButton = findViewById(R.id.convertButton)
        resultTextView = findViewById(R.id.resultTextView)
        conversionTypeSpinner = findViewById(R.id.conversionTypeSpinner)

        viewModel = ViewModelProvider(this).get(CurrencyConverterViewModel::class.java)

        convertButton.setOnClickListener {
            val amount = inputAmount.text.toString()
            val conversionType = conversionTypeSpinner.selectedItem.toString()
            viewModel.convertCurrency(amount, conversionType)
        }

        viewModel.conversionResult.observe(this) { result ->
            resultTextView.text = result?.let { "$it" } ?: "Error en la conversión"
        }

    }
}
