package com.example.calculadora

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "info_clique"

    var textoNumero1 = "0"
    var textoNumero2 = "0"
    private var operacao = "+"
    var temPonto = false
    var resultado = 0.0

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }

    @SuppressLint("SetTextI18n")
    fun cliqueIgual(botao: View){


        if(binding.editRestulado.text.isEmpty()){
            textoNumero2 = "0"
        }else{
            textoNumero2 = binding.editRestulado.text.toString()
        }


        val numero1 = textoNumero1.toDouble()
        val numero2 = textoNumero2.toDouble()

        when(operacao){
            "+" ->{
                resultado = numero1 + numero2
            }
            "-" ->{
                resultado = numero1 - numero2
            }
            "*" ->{
                resultado = numero1 * numero2
            }
            "/" ->{
                resultado = numero1 / numero2
            }
        }
        binding.editRestulado.setText(resultado.toString())
        textoNumero1 = "0"
        textoNumero2 = "0"
        operacao = "+"
        zero()
        Log.i(TAG, "n1:${numero1} operação:${operacao} n2:${numero2} resultado:${resultado}")

    }

    @SuppressLint("SetTextI18n")
    fun cliqueOperação(botao: View){


        textoNumero1 = binding.editRestulado.text.toString()


        when(botao.id){
            binding.btnSomar.id -> operacao = "+"
            binding.btnSubtrair.id -> operacao = "-"
            binding.btnMultiplicar.id -> operacao = "*"
            binding.btnDividir.id -> operacao = "/"
            binding.btnLimpar.id -> {
                textoNumero1 = "0"
                textoNumero2 = "0"
                binding.editRestulado.setText("")
            }

        }
        binding.editRestulado.setText("")
        temPonto = false
        Log.i(TAG, "n1:${textoNumero1} operação:${operacao}")


    }

    fun zero(){
        if (binding.editRestulado.text == "0.0"){
            binding.editRestulado.setText("")
        }
    }

    fun cliqueNumero (botao: View){// configurando onclique do activity
        //Log.i("btn_clique: ","id clicado: ${botao.id} id item: ${binding.btn7.id}")  verificando que o numero id do clique é o mesmo numero id do botao
//        val botaoSelecionado = botao as Button
        var textNumeroSelecionado = binding.editRestulado.text.toString()
        when(botao.id){
            binding.btn0.id -> textNumeroSelecionado += "0"
            binding.btn1.id -> textNumeroSelecionado += "1"
            binding.btn2.id -> textNumeroSelecionado += "2"
            binding.btn3.id -> textNumeroSelecionado += "3"
            binding.btn4.id -> textNumeroSelecionado += "4"
            binding.btn5.id -> textNumeroSelecionado += "5"
            binding.btn6.id -> textNumeroSelecionado += "6"
            binding.btn7.id -> textNumeroSelecionado += "7"
            binding.btn8.id -> textNumeroSelecionado += "8"
            binding.btn9.id -> textNumeroSelecionado += "9"
            binding.btnPonto.id -> {
                if (!temPonto){    // SENAO TEM PONTO
                    textNumeroSelecionado += "."
                    temPonto = true
                }
            }
        }
        binding.editRestulado.setText(textNumeroSelecionado)



    }
}