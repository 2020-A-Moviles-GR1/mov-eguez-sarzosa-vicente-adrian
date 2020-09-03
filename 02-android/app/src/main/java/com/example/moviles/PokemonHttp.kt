package com.example.moviles

import java.util.*

class PokemonHttp(
    val createdAt: Long,
    val updatedAt: Long,
    var id: Int,
    var nombre: String,
    var usuario: Int
) {
    var fechaCreacion: Date
    var fechaActualizacion: Date

    init {
        fechaCreacion = Date(createdAt)
        fechaActualizacion = Date(updatedAt)
    }
}