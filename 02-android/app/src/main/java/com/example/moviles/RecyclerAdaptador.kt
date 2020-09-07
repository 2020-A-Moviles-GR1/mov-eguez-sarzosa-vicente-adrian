package com.example.moviles

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Para usar el RecyclerView necesitamos migrar a Android X y añadir la dependencia:
// implementation 'com.android.support:recyclerview-v7:28.0.0'
class RecyclerAdaptador(
    private val listaUsuarios: List<UsuarioHttp>,
    private val contexto: RecyclerVIewActivity,
    private val recyclerView: androidx.recyclerview.widget.RecyclerView
) : androidx.recyclerview.widget.RecyclerView.Adapter<RecyclerAdaptador.MyViewHolder>() {
    inner class MyViewHolder(view: View) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {

        val nombreTextView: TextView
        val cedulaTextView: TextView
        val likesTextView: TextView
        val acccionButton: Button
        var numeroLikes = 0

        init {
            nombreTextView = view.findViewById(R.id.tv_nombre)
            cedulaTextView = view.findViewById(R.id.tv_cedula)
            acccionButton = view.findViewById(R.id.btn_accion)
            likesTextView = view.findViewById(R.id.tv_likes)
            acccionButton.setOnClickListener {
                this.anadirLike()
            }
        }

        fun anadirLike(){
            this.numeroLikes = this.numeroLikes + 1
            likesTextView.text = this.numeroLikes.toString()
            contexto.anadirLikesEnActividad(1)
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdaptador.MyViewHolder {
        //  Definimos la interfaz que vamos a usar
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.adaptador_persona, // Recursos adaptador_persona.xml
                parent,
                false
            )
        return MyViewHolder(itemView)
    }

    // # Items que tenemos en la lista
    override fun getItemCount(): Int {
        return listaUsuarios.size
    }

    // Es una funcion que se va a ejecutar con cada uno de los items (iterable)
    override fun onBindViewHolder(
        holder: MyViewHolder, // Clase implementada (arriba)
        position: Int) { // Posicion
        val usuario = listaUsuarios[position]
        holder.nombreTextView.text = usuario.nombre
        holder.cedulaTextView.text = usuario.cedula
        holder.acccionButton.text = "Like ${usuario.nombre}"

        holder.likesTextView.text = "0"

    }

}