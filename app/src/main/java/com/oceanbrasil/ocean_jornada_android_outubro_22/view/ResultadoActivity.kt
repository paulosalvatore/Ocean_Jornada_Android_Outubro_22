package com.oceanbrasil.ocean_jornada_android_outubro_22.view

//import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
//import android.widget.Toast
//import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.oceanbrasil.ocean_jornada_android_outubro_22.R

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

            // Exemplo de caixa de diálogo para fechar
//            val builder = AlertDialog.Builder(this)
//            builder.setMessage("Deseja fechar?")
//                .setPositiveButton(
//                    android.R.string.ok
//                ) { _, _ ->
//                    finish()
//                }
//                .setNegativeButton(
//                    android.R.string.cancel
//                ) { _, _ ->
//                    Toast.makeText(this, "Tudo bem :(", Toast.LENGTH_LONG).show()
//                }
//            builder.create()
//            builder.show()
        }
    }
}
