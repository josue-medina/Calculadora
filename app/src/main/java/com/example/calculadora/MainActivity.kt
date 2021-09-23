package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var firsValue: Double = 0.0
    var operator: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)
        binding.btnBorrar.setOnClickListener {
            binding.etCalcu.setText(binding.etCalcu.text.dropLast(1))
        }

        binding.btnLimpiar.setOnClickListener {
            binding.etCalcu.text.clear()
        }

        binding.btnIgual.setOnClickListener {
            when(operator){
                "Multiplicacion" ->{
                    binding.etCalcu.setText("${firsValue * binding.etCalcu.text.toString().toDouble()}")
                }
                "Division" -> {
                    binding.etCalcu.setText("${firsValue / binding.etCalcu.text.toString().toDouble()}")
                }
                "Resta" -> {
                    binding.etCalcu.setText("${firsValue - binding.etCalcu.text.toString().toDouble()}")
                }
                "Suma" -> {
                    binding.etCalcu.setText("${firsValue + binding.etCalcu.text.toString().toDouble()}")
                }
            }
        }

        //boton % divide el numero entre 100
        binding.btnPorcentaje.setOnClickListener {
            binding.etCalcu.setText("${binding.etCalcu.text.toString().toDouble() / 100}")
        }

    }

    fun presionoBoton (view: View){
        val button = view as Button

        when(button.id){
            binding.btnPunto.id -> {
                if (!binding.etCalcu.text.contains('.')) {
                    binding.etCalcu.text.append(".")
                }
            }
            binding.btnNum0.id -> { binding.etCalcu.text.append("0")}
            binding.btnNum1.id -> { binding.etCalcu.text.append("1")}
            binding.btnNum2.id -> { binding.etCalcu.text.append("2")}
            binding.btnNum3.id -> { binding.etCalcu.text.append("3")}
            binding.btnNum4.id -> { binding.etCalcu.text.append("4")}
            binding.btnNum5.id -> { binding.etCalcu.text.append("5")}
            binding.btnNum6.id -> { binding.etCalcu.text.append("6")}
            binding.btnNum7.id -> { binding.etCalcu.text.append("7")}
            binding.btnNum8.id -> { binding.etCalcu.text.append("8")}
            binding.btnNum9.id -> { binding.etCalcu.text.append("9")}
            else -> {Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show() }
        }
    }

    fun operatorClicked(view: View){
        val button = view as Button

        operator = when(button.id){
            binding.btnMultiplicacion.id ->{"Multiplicacion"}
            binding.btnDivicion.id ->{"Division"}
            binding.btnSuma.id ->{"Suma"}
            binding.btnResta.id ->{"Resta"}
            else ->{ "" }
        }
        firsValue = binding.etCalcu.text.toString().toDouble()
        binding.etCalcu.text.clear()
    }
}