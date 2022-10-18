package com.oceanbrasil.ocean_jornada_android_outubro_22.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oceanbrasil.ocean_jornada_android_outubro_22.R
import com.oceanbrasil.ocean_jornada_android_outubro_22.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        // Construção da lista

        // ----> Código aqui
        val rvCriaturas = root.findViewById<RecyclerView>(R.id.rvCriaturas)
        rvCriaturas.layoutManager = LinearLayoutManager(root.context)
        // TODO: Criar o Adapter
        rvCriaturas.adapter = null

        // Fim da construção da lista

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}