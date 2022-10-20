package com.oceanbrasil.ocean_jornada_android_outubro_22

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CriaturasAdapter(
    private val itens: List<Criatura>
) : RecyclerView.Adapter<CriaturasAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Criatura) {
            val tvNome = itemView.findViewById<TextView>(R.id.tvNome)
            val ivCriatura = itemView.findViewById<ImageView>(R.id.ivCriatura)

            tvNome.text = item.nome
            // TODO: Carregar imagem no ivCriatura
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val view = layoutInflater.inflate(R.layout.criatura_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itens[position]
        holder.bindView(item)
    }

    override fun getItemCount(): Int {
        return itens.size
    }
}
