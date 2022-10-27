package com.oceanbrasil.ocean_jornada_android_outubro_22.view.criatura

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.oceanbrasil.ocean_jornada_android_outubro_22.R
import com.oceanbrasil.ocean_jornada_android_outubro_22.databinding.FragmentCriaturaBinding

class CriaturaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCriaturaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val safeArgs: CriaturaFragmentArgs by navArgs()

        val tvNome = view.findViewById<TextView>(R.id.tvNome)
        val ivCriatura = view.findViewById<ImageView>(R.id.ivCriatura)

        tvNome.text = safeArgs.nome
        Glide.with(view).load(safeArgs.imagemUrl).into(ivCriatura)
    }
}
