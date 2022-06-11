package com.example.aprimorandoconhecimentoss.ui.coordenacoes

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aprimorandoconhecimentoss.R
import com.example.aprimorandoconhecimentoss.databinding.FragmentCoordenacoesBinding
import com.example.aprimorandoconhecimentoss.ui.CoordenadorAdapter
import com.example.aprimorandoconhecimentoss.ui.entidades.CoordenacoesEnt
import java.util.ArrayList

class Coordenacoes : Fragment() {

    private var _binding: FragmentCoordenacoesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):  View {

        _binding = FragmentCoordenacoesBinding.inflate(inflater, container, false)

        /* Acessando a Toolbar da atividade principal */
        /*val toolbar = activity?.findViewById<View>(R.id.toolbar) as Toolbar
        toolbar.title = "Coordenações academicas";
        toolbar.subtitle = "Coordenações"*/


        val professores = arrayOf<String>("Profa. Dra. Francislene Glória de Freitas Reis",
            "Profa Dra. Maria Emilia Soares Martins dos Santos",
            "Profa Dra. Patricia Helena Zanier Gomes",
            "Danilo Rodrigues Goulart Pasquareli",
            "Lucas Daniel Soares de Oliveira",
            "Ana Carolina Dias de Oliveira")
        val funcoes = arrayOf<String>("Coordenador","Coordenador","Coordenador","Tutor","Tutor","Tutor")
        val images = arrayOf<Int>(
            R.drawable.francislene, R.drawable.mariaemilia, R.drawable.patriciazanier,
            R.drawable.lucasdaniel, R.drawable.danilorodrigues, R.drawable.anacarolina)

        var arrayListCoordenador = ArrayList<CoordenacoesEnt>()

        for(i in professores.indices){
            // usando classe modelo
            val prof = CoordenacoesEnt(professores[i],funcoes[i],images[i])
            arrayListCoordenador.add(prof)
        }

        binding.listviewCoordenacoes.isClickable = true
        binding.listviewCoordenacoes.adapter = CoordenadorAdapter(requireActivity(), arrayListCoordenador)
        /*binding.listviewCoordenacoes.setOnClickListener{}*/




        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}