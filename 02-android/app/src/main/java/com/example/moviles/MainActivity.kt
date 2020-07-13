package com.example.moviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_ciclo_vida
            .setOnClickListener { boton ->
                // this.irCicloDeVida()
                irCicloDeVida()
            }

        btn_list_view
            .setOnClickListener { boton ->
                irListView()
            }

    }

    fun irListView() {
        val intentExplicito = Intent(
            this,
            BListViewActivity::class.java
        )
        // this.startActivity(intentExplicito)
        startActivity(intentExplicito)
    }

    fun irCicloDeVida() {
        val intentExplicito = Intent(
            this,
            CicloVida::class.java
        )
        // this.startActivity(intentExplicito)
        startActivity(intentExplicito)
    }


}