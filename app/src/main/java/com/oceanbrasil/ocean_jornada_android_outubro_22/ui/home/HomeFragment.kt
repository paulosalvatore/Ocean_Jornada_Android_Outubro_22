package com.oceanbrasil.ocean_jornada_android_outubro_22.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oceanbrasil.ocean_jornada_android_outubro_22.Criatura
import com.oceanbrasil.ocean_jornada_android_outubro_22.CriaturasAdapter
import com.oceanbrasil.ocean_jornada_android_outubro_22.R
import com.oceanbrasil.ocean_jornada_android_outubro_22.api.CriaturaService
import com.oceanbrasil.ocean_jornada_android_outubro_22.databinding.FragmentHomeBinding
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
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        // Construção da lista

        val rvCriaturas = root.findViewById<RecyclerView>(R.id.rvCriaturas)
        rvCriaturas.layoutManager = LinearLayoutManager(root.context)

//        val criaturas = listOf(
//            Criatura("Criatura 1", R.drawable.criatura_nestjs),
//            Criatura("Criatura 2", R.drawable.criatura_nestjs)
//        )
//
//        rvCriaturas.adapter = CriaturasAdapter(criaturas)

        // Carregamento dos dados da API

        val retrofit = Retrofit.Builder()
            .baseUrl("https://backend-livro-android-casa-cod.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(CriaturaService::class.java)

        val call = service.listar()

        // Exibimos a mensagem informando que iniciamos o carregamento
        Toast.makeText(context, "Carregando criaturas...", Toast.LENGTH_LONG).show()

        // Iniciamos o carregamento
        call.enqueue(object : Callback<List<Criatura>> {
            // Em caso de sucesso
            override fun onResponse(
                call: Call<List<Criatura>>,
                response: Response<List<Criatura>>
            ) {
                val resultado = response.body()

                resultado?.let {
                    // Exibir uma mensagem de sucesso
                    Toast.makeText(this@HomeFragment.context, "Criaturas carregadas com sucesso!", Toast.LENGTH_LONG).show()

                    // Carregar a lista de criaturas na RecyclerView
                    rvCriaturas.adapter = CriaturasAdapter(resultado)
                }
            }

            // Em caso de falha
            override fun onFailure(call: Call<List<Criatura>>, t: Throwable) {
                // Exibimos uma mensagem que o carregamento falhou
                Toast.makeText(this@HomeFragment.context, "Erro ao carregar criaturas :(", Toast.LENGTH_LONG).show()

                // Enviamos o erro para o Logcat (onde ficam os logs no Android Studio)
                Log.e("CRIATURAS", "Falha na requisição.", t)
            }
        })

        // Fim da construção da lista

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
