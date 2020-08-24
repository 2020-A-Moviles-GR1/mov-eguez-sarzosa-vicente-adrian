package com.example.moviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_http.*

class HttpActivity : AppCompatActivity() {
    val urlPrincipal = "http://192.168.20.129:1337"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http)

        btn_obtener
            .setOnClickListener {
                obtenerUsuarios()
            }
    }

    fun obtenerUsuarios(){
        val url = urlPrincipal + "/Usuario"
        url
            .httpGet()
            .responseString {
                request, response, result ->
                when(result){
                    is Result.Success -> {
                        val data = result.get()
                        Log.i("http-klaxon","Data: ${data}")
                    }
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http-klaxon", "Error: ${ex.message}")
                    }
                }
            }


    }
}