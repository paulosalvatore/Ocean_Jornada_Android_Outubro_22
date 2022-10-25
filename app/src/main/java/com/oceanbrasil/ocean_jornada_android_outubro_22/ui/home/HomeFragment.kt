package com.oceanbrasil.ocean_jornada_android_outubro_22.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oceanbrasil.ocean_jornada_android_outubro_22.Criatura
import com.oceanbrasil.ocean_jornada_android_outubro_22.CriaturasAdapter
import com.oceanbrasil.ocean_jornada_android_outubro_22.R
import com.oceanbrasil.ocean_jornada_android_outubro_22.api.CriaturaService
import com.oceanbrasil.ocean_jornada_android_outubro_22.databinding.FragmentHomeBinding
import com.oceanbrasil.ocean_jornada_android_outubro_22.viewmodel.CriaturasViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
            ViewModelProvider(this)
                .get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        // Construção da lista

        val rvCriaturas = root.findViewById<RecyclerView>(R.id.rvCriaturas)
//        rvCriaturas.layoutManager = LinearLayoutManager(root.context)
        rvCriaturas.layoutManager = GridLayoutManager(root.context, 2)

//        val criaturas = listOf(
//            Criatura("Criatura 1", R.drawable.criatura_nestjs),
//            Criatura("Criatura 2", R.drawable.criatura_nestjs)
//        )

        val criaturasViewModel =
            ViewModelProvider(this)
                .get(CriaturasViewModel::class.java)

        criaturasViewModel.criaturas.observe(viewLifecycleOwner) {
            rvCriaturas.adapter = CriaturasAdapter(it)
        }

//        val criaturas = criaturasViewModel.pegarCriaturas()
//        rvCriaturas.adapter = CriaturasAdapter(criaturas)

        // Fim da construção da lista

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
