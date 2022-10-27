package com.oceanbrasil.ocean_jornada_android_outubro_22.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oceanbrasil.ocean_jornada_android_outubro_22.view.CriaturasAdapter
import com.oceanbrasil.ocean_jornada_android_outubro_22.R
import com.oceanbrasil.ocean_jornada_android_outubro_22.databinding.FragmentHomeBinding
import com.oceanbrasil.ocean_jornada_android_outubro_22.viewmodel.CriaturasViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Construção da lista

        val rvCriaturas = root.findViewById<RecyclerView>(R.id.rvCriaturas)
//        rvCriaturas.layoutManager = LinearLayoutManager(root.context)
        rvCriaturas.layoutManager = GridLayoutManager(root.context, 2)

        val criaturasViewModel =
            ViewModelProvider(this)
                .get(CriaturasViewModel::class.java)

        criaturasViewModel.criaturas.observe(viewLifecycleOwner) {
            // Exibimos uma mensagem de sucesso
            Toast.makeText(
                this@HomeFragment.context,
                "Criaturas carregadas com sucesso!",
                Toast.LENGTH_LONG
            ).show()

            // Atualizamos a RecyclerView com um novo Adapter, com a lista nova
            rvCriaturas.adapter = CriaturasAdapter(it)
        }

        // Fim da construção da lista

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
