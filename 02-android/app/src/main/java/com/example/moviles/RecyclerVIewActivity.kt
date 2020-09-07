package com.example.moviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_recycler_v_iew.*
import java.util.ArrayList

class RecyclerVIewActivity : AppCompatActivity() {
    var numeroLikes = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_v_iew)

        val listaUsuarios = arrayListOf<UsuarioHttp>()
        listaUsuarios.add(
            UsuarioHttp(
                1,
                123123123,
                123123123,
                "1718137169",
                "Adrian",
                "a@a.com",
                "Soltero",
                "123456",
                arrayListOf<PokemonHttp>()
            )
        )
        listaUsuarios.add(
            UsuarioHttp(
                2,
                123123123,
                123123123,
                "2518137133",
                "Vicente",
                "b@b.com",
                "Soltero",
                "123456",
                arrayListOf<PokemonHttp>()
            )
        )
        listaUsuarios.add(
            UsuarioHttp(
                3,
                123123123,
                123123123,
                "0518133456",
                "Wendy",
                "c@c.com",
                "Soltero",
                "123456",
                arrayListOf<PokemonHttp>()
            )
        )

        iniciarRecyclerView(
            listaUsuarios,
            this,
            rv_usuarios
        )
    }

    fun iniciarRecyclerView(
        lista: List<UsuarioHttp>,
        actividad: RecyclerVIewActivity,
        recycler_view: androidx.recyclerview.widget.RecyclerView
    ) {
        val adaptadorUsuario = RecyclerAdaptador(
            lista,
            actividad,
            recycler_view
        )
        rv_usuarios.adapter = adaptadorUsuario
        rv_usuarios.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
        rv_usuarios.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(actividad)
        adaptadorUsuario.notifyDataSetChanged()
    }

    fun anadirLikesEnActividad(numero: Int) {
        this.numeroLikes = this.numeroLikes + numero
        tv_titulo_rv.text = numeroLikes.toString()
    }
}








