package com.oceanbrasil.ocean_jornada_android_outubro_22

data class Criatura(
    val number: Int,

    val name: String,

    val image: String,

    val legendary: Boolean,

    val evolveTo: Criatura?
)
