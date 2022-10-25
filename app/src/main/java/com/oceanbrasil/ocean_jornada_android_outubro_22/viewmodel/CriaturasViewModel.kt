package com.oceanbrasil.ocean_jornada_android_outubro_22.viewmodel

import androidx.lifecycle.ViewModel
import com.oceanbrasil.ocean_jornada_android_outubro_22.Criatura

class CriaturasViewModel : ViewModel() {
    // TODO: Colocar a lista de criaturas dentro do ViewModel
    // TODO: A partir disso, vamos carregar a RecyclerView com essa lista

    val criaturas = listOf(
        Criatura(1, "Java", "https://i.imgur.com/PHfd1h2.png", false, null),
        Criatura(2, "Kotlin", "https://i.imgur.com/EZ3zCBp.png", false, null)
    )
}
