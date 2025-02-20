package com.example.simplecalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNumber1 = findViewById<EditText>(R.id.etNumber1)
        val etNumber2 = findViewById<EditText>(R.id.etNumber2)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSubtract = findViewById<Button>(R.id.btnSubtract)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDivide = findViewById<Button>(R.id.btnDivide)

        fun getNumbers(): Pair<Double, Double>? {
            val num1 = etNumber1.text.toString()
            val num2 = etNumber2.text.toString()

            if (num1.isEmpty() || num2.isEmpty()) {
                Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
                return null
            }

            return Pair(num1.toDouble(), num2.toDouble())
        }

        btnAdd.setOnClickListener {
            val numbers = getNumbers()
            if (numbers != null) {
                val result = numbers.first + numbers.second
                tvResult.text = "Result: $result"
            }
        }

        btnSubtract.setOnClickListener {
            val numbers = getNumbers()
            if (numbers != null) {
                val result = numbers.first - numbers.second
                tvResult.text = "Result: $result"
            }
        }

        btnMultiply.setOnClickListener {
            val numbers = getNumbers()
            if (numbers != null) {
                val result = numbers.first * numbers.second
                tvResult.text = "Result: $result"
            }
        }

        btnDivide.setOnClickListener {
            val numbers = getNumbers()
            if (numbers != null) {
                if (numbers.second == 0.0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                } else {
                    val result = numbers.first / numbers.second
                    tvResult.text = "Result: $result"
                }
            }
        }
    }
}
