package com.oceanbrasil.ocean_jornada_android_outubro_22.viewmodel

import androidx.lifecycle.ViewModel
import com.oceanbrasil.ocean_jornada_android_outubro_22.model.CriaturasRepository

class CriaturasViewModel : ViewModel() {
    private val repository = CriaturasRepository()

    val criaturas = repository.criaturas
}
