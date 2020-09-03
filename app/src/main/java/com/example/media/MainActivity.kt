package com.example.media

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcularNota(v:View){
        val nome = et_nome.text.toString()
        val nota1 = et_nota1.text.toString().toDouble()
        val nota2 = et_nota2.text.toString().toDouble()

        if(nome.length <= 1 ) {
            Toast.makeText(this, "Digite um nome válido!", Toast.LENGTH_SHORT).show()
        }else if(nota1 > 10.0 || nota2 > 10.0){
            Toast.makeText(this, "Não é permitido numeros maiores que 10", Toast.LENGTH_SHORT).show()
        }else {
            Toast.makeText(this, "Tudo certo!", Toast.LENGTH_SHORT).show()

            val media = (nota1 + nota2) / 2

            if (media < 5.0) {
                tv_resposta.text = "$nome, sua média é: $media. Você foi REPROVADO!"
                tv_resposta.setTextColor(Color.RED)
            } else if (media >= 6.0) {
                tv_resposta.text = "$nome, sua média é: $media. Você foi APROVADO!"
                tv_resposta.setTextColor(Color.BLUE)
            } else {
                tv_resposta.text =
                    "$nome, sua média é: $media. Você foi aprovado, mas pode melhorar!"
                tv_resposta.setTextColor(Color.GREEN)
            }
        }
    }
}