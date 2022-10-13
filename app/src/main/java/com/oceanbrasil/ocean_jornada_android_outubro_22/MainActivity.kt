package com.oceanbrasil.ocean_jornada_android_outubro_22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Detecta clique no botão
        //   a. Pegar o `Button` pelo `ID`
        //   b. Criar um `listener` para esse `Button` que foi encontrado
        // 2. Atualizar o conteúdo o `TextView` para o nosso nome
        //   a. Pegar o `TextView` pelo `ID`
        //   b. Atualizar a propriedade `text` do `TextView`

        // Variáveis em Kotlin começando com val ou var
        // Val = não muda o valor depois de inicializada
        // Var = permite a alteração do valor
        // Dentro de <>, colocamos o TIPO da informação (ex: Button, TextView, EditText etc.)
        // Dentro de (), colocamos o ID do elemento (ex: R.id.tvResultado, R.id.btEnviar etc.)
        val btEnviar = findViewById<Button>(R.id.btEnviar)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val etNome = findViewById<EditText>(R.id.etNome)

        // Para criar um listener para uma View (Button, TextView etc.), utilizamos a
        // declaração setOnClickListener { }
        btEnviar.setOnClickListener {
            // Dentro das { } (chaves) do Listener, temos o código que é
            // executado no momento que o Click (toque no botão) acontece

            // Atualizamos a propriedade `text` do `TextView`
            tvResultado.text = etNome.text
        }
    }
}
