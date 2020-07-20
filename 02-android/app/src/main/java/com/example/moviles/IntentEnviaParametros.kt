package com.example.moviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class IntentEnviaParametros : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_envia_parametros)
        // Propiedad Clase intent
        // this.intent
        val numeroEncontrado = intent.getIntExtra(
            "numero",
            0
        )
        Log.i("intents", "El numero encontrado es:${numeroEncontrado}")

    }
}