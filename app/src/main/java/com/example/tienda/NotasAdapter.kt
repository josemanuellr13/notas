package com.example.tienda

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tienda.databinding.NotaItemBinding

class NotasAdapter(private val NotaClickedListener : (Nota) -> Unit) : RecyclerView.Adapter<NotasAdapter.ViewHolder>() {
    var notas = emptyList<Nota>()

    companion object{
        const val ACTION_VIEW = "ubicación seleccionada"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.nota_item, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val nota = notas[position]
        holder.bind(nota)
        holder.itemView.setOnClickListener(){
            NotaClickedListener(nota)
        }
    }

    override fun getItemCount(): Int = notas.size


    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        private val binding = NotaItemBinding.bind(view)

        fun bind(nota: Nota) {
            binding.titulo.text = nota.titulo
            binding.contenido.text = shortContenido(nota.contenido)
        }

        fun shortContenido(contenido: String): String {

            return contenido.toString().substring(0, 90) + "..."
        }
    }




}