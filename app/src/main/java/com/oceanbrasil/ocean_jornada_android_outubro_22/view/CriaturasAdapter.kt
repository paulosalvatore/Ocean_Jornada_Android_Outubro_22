package com.oceanbrasil.ocean_jornada_android_outubro_22.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oceanbrasil.ocean_jornada_android_outubro_22.model.Criatura
import com.oceanbrasil.ocean_jornada_android_outubro_22.R

class CriaturasAdapter(
    private val itens: List<Criatura>
) : RecyclerView.Adapter<CriaturasAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Criatura) {
            val tvNome = itemView.findViewById<TextView>(R.id.tvNome)
            val ivCriatura = itemView.findViewById<ImageView>(R.id.ivCriatura)

            tvNome.text = item.name

//            ivCriatura.setImageResource(item.imagem)
            Glide.with(itemView).load(item.image).into(ivCriatura)
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
