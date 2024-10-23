package com.example.myapplication

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class   MainActivity : ComponentActivity() {

    private lateinit var areaInput: EditText
    private lateinit var rateInput: EditText
    private lateinit var calculateButton: Button
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Инициализация элементов интерфейса
        areaInput = findViewById(R.id.areaInput)
        rateInput = findViewById(R.id.rateInput)
        calculateButton = findViewById(R.id.calculateButton)
        resultText = findViewById(R.id.resultText)


        calculateButton.setOnClickListener { calculateCost() }
    }

    private fun calculateCost() {
        // Получение введенных данных
        val area = areaInput.text.toString().toDoubleOrNull()
        val rate = rateInput.text.toString().toDoubleOrNull()

        // Проверка на корректность введенных данных
        if (area == null || rate == null) {
            resultText.text = "Пожалуйста, введите корректные значения."
            return
        }

        // Расчет стоимости
        val totalCost = area * rate
        resultText.text = "Общая стоимость: %.2f".format(totalCost)
    }
}