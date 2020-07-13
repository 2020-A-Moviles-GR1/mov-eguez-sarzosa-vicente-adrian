package com.example.moviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_ciclo_vida.*

class CicloVida : AppCompatActivity() {

    var numeroActual = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciclo_vida)
        Log.i("Activity", "OnCreate")

        numeroActual = ServicioBDDMemoria.numero
        if (numeroActual != 0) {
            tv_numero.text = numeroActual.toString()
        }

        btn_anadir
            .setOnClickListener {
                sumarUnValor()
            }
    }

    fun sumarUnValor() {
        numeroActual = numeroActual + 1
        ServicioBDDMemoria.anadirNumero()
        tv_numero.text = numeroActual.toString()
    }

    override fun onStart() {
        super.onStart()
        Log.i("Activity", "OnStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Activity", "OnRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Activity", "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Activity", "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Activity", "OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Activity", "OnDestroy")
    }

    override fun onSaveInstanceState(
        outState: Bundle
    ) {
        Log.i("activity", "onSaveInstanceState")
        outState?.run {
            putInt("numeroActualGuardado", numeroActual)
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle
    ) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("activity", "onRestoreInstanceState")
        val valorRecuperado = savedInstanceState
            ?.getInt("numeroActualGuardado")

        if (valorRecuperado != null) {
            this.numeroActual = valorRecuperado
            tv_numero.text = this.numeroActual.toString()
        }
    }


}