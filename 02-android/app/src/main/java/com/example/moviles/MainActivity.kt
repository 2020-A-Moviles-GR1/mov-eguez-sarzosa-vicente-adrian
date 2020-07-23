package com.example.moviles

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
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

        btn_intent_respuesta
            .setOnClickListener {
                irAIntentConRespuesta()
            }

        btn_intent_implicito
            .setOnClickListener {
                enviarIntentConRespuesta()
            }

        btn_resp_propia
            .setOnClickListener {
                enviarIntentConRespuestaPropia()
            }


    }

    fun enviarIntentConRespuestaPropia() {
        val intentExplicito = Intent(
            this,
            IntentEnviaParametros::class.java
        )
        startActivityForResult(intentExplicito, 305)
    }

    fun enviarIntentConRespuesta() {
        val intentConRespuesta = Intent(
            Intent.ACTION_PICK,
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        )

        // this.startActivityForResult(intent, codigoDeRespuesta)
        // 304 lo pusimos nosotros, no es ningun numero en especial
        startActivityForResult(intentConRespuesta, 304)
    }

    override fun onActivityResult(
        requestCode: Int, // Numero que enviamos
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        when (resultCode) {
            RESULT_OK -> {
                Log.i("resultado", "OK")

                when (requestCode) {
                    304 -> { // Contactos
                        val uri = data?.data
                        if (uri != null) {
                            val cursor = contentResolver.query(
                                uri,
                                null,
                                null,
                                null,
                                null,
                                null
                            )
                            cursor?.moveToFirst()
                            val indiceTelefono = cursor?.getColumnIndex(
                                ContactsContract.CommonDataKinds.Phone.NUMBER
                            )
                            val telefono = cursor?.getString(indiceTelefono!!)
                            cursor?.close()
                            Log.i("resultado", "Telefono: ${telefono}")
                        }
                    }
                    305 -> {
                        if (data!= null){
                            val nombre = data.getStringExtra("nombre")
                            val edad = data.getIntExtra("edad", 0)
                            Log.i("resultado", "Nombre: ${nombre} Edad: ${edad}")
                        }
                    }
                }
            }
            RESULT_CANCELED -> {
                Log.i("resultado", "=(")
            }
        }
    }


    fun irAIntentConRespuesta() {
        val intentExplicito = Intent(
            this,
            IntentEnviaParametros::class.java
        )
        intentExplicito.putExtra("numero", 2)
        startActivity(intentExplicito)
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