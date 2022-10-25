package com.oceanbrasil.ocean_jornada_android_outubro_22.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.oceanbrasil.ocean_jornada_android_outubro_22.Criatura
import com.oceanbrasil.ocean_jornada_android_outubro_22.api.CriaturaService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CriaturasRepository {
    val criaturas = MutableLiveData<List<Criatura>>()

    init {
        // Carregamento dos dados da API

        val retrofit = Retrofit.Builder()
            .baseUrl("https://backend-livro-android-casa-cod.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(CriaturaService::class.java)

        val call = service.listar()

        // Iniciamos o carregamento
        call.enqueue(object : Callback<List<Criatura>> {
            // Em caso de sucesso
            override fun onResponse(
                call: Call<List<Criatura>>,
                response: Response<List<Criatura>>
            ) {
                val resultado = response.body()

                resultado?.let {
                    // Atualizamos o LiveData com o valor da lista
                    criaturas.value = it
                }
            }

            // Em caso de falha
            override fun onFailure(call: Call<List<Criatura>>, t: Throwable) {
                // Enviamos o erro para o Logcat (onde ficam os logs no Android Studio)
                Log.e("CRIATURAS", "Falha na requisição.", t)
            }
        })
    }
}
