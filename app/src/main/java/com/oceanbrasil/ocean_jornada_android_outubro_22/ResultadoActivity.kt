package com.oceanbrasil.ocean_jornada_android_outubro_22

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        // Exibição do que foi digitado na outra tela

        val nomeDigitado = intent.getStringExtra("NOME_DIGITADO")

        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        tvResultado.text = nomeDigitado

        // Funcionamento do Botão Voltar

        val btVoltar = findViewById<Button>(R.id.btVoltar)

        // Detectamos um clique no botão voltar
        btVoltar.setOnClickListener {
            // Finalizamos a tela atual
            finish()
        }
    }
}
