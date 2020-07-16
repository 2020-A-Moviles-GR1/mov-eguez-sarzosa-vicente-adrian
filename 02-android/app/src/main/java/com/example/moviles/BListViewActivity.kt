package com.example.moviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_b_list_view.*

class BListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b_list_view)

        val listaEntrenadores: ArrayList<Entrenador> = arrayListOf<Entrenador>()

        listaEntrenadores.add(Entrenador("Adrian", "Eguez"))
        listaEntrenadores.add(Entrenador("Vicente", "Sarzosa"))
        listaEntrenadores.add(Entrenador("Wendy", "Moises"))
        listaEntrenadores.add(Entrenador("Ivan", "Parra"))
        listaEntrenadores.add(Entrenador("Juan", "Duran"))
        listaEntrenadores.add(Entrenador("Andrea", "Lara"))
        listaEntrenadores.add(Entrenador("Lisa", "Guerrero"))

        val adaptador: ArrayAdapter<Entrenador> = ArrayAdapter(
            this, // Contexto
            android.R.layout.simple_list_item_1, // Nombre Layout
            listaEntrenadores // Lista
        )

        lv_numeros.adapter = adaptador

        lv_numeros
            .onItemClickListener = AdapterView.OnItemClickListener {
                parent, view, position, id ->
            Log.i("list-view", "Posicion $position")
        }

        btn_anadir_entrenador
            .setOnClickListener {
                anadirEntrenador(
                    adaptador,
                    listaEntrenadores
                )
            }

    }

    fun anadirEntrenador(
        adaptador: ArrayAdapter<Entrenador>,
        listaEntrenadores: ArrayList<Entrenador>
    ){
        listaEntrenadores.add(
            Entrenador("Nuevo", "Entrenador")
        )
        adaptador.notifyDataSetChanged()
    }

}