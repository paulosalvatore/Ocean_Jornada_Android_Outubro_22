package com.oceanbrasil.ocean_jornada_android_outubro_22.api

import com.oceanbrasil.ocean_jornada_android_outubro_22.Criatura
import retrofit2.Call
import retrofit2.http.GET

interface CriaturaService {
    @GET("creature")
    fun listar(): Call<List<Criatura>>
}
