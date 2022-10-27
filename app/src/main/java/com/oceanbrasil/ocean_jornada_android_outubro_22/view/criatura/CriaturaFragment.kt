package com.oceanbrasil.ocean_jornada_android_outubro_22.view.criatura

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
}
