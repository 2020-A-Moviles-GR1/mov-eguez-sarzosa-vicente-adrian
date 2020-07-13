package com.example.moviles

class ServicioBDDMemoria {
    companion object {
        var numero = 0
        fun anadirNumero() {
            this.numero = this.numero + 1
        }
    }
}