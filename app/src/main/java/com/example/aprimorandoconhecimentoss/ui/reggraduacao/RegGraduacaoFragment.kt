package com.example.aprimorandoconhecimentoss.ui.reggraduacao

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.aprimorandoconhecimentoss.R
import com.example.aprimorandoconhecimentoss.databinding.FragmentPdfvisualizadorBinding
import com.example.aprimorandoconhecimentoss.databinding.RegulamentoGradFragmentBinding
import com.example.aprimorandoconhecimentoss.ui.constantes.Regulamentos
import com.example.aprimorandoconhecimentoss.ui.entidades.CoordenacoesEnt

class RegGraduacaoFragment : Fragment() {

    private var _binding: RegulamentoGradFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = RegulamentoGradFragmentBinding.inflate(inflater, container, false)

        /*val toolbar = activity?.findViewById<View>(R.id.toolbar_inicial) as TextView
        toolbar.text = "Regulamento da graduação"*/

        /*val lista = activity?.findViewById<View>(R.id.lista_reggraduacao) as RecyclerView*/


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