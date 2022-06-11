package com.example.aprimorandoconhecimentoss.ui.calendario

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.aprimorandoconhecimentoss.R
import com.example.aprimorandoconhecimentoss.databinding.FragmentCalendarioBinding
import com.example.aprimorandoconhecimentoss.ui.constantes.urlpdf


class CalendarioFragment : Fragment() {

    private var _binding: FragmentCalendarioBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    companion object Factory {
        fun create(): CalendarioFragment = create()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCalendarioBinding.inflate(inflater, container, false)

        /*val texto_tbar = activity?.findViewById<View>(R.id.toolbar_inicial) as TextView
        texto_tbar.text = "Calendário Acadêmico"
        setHasOptionsMenu(true)*/

        binding.botaoView1.setOnClickListener {
            val bundle = Bundle()
            val tipopdf = "pdf_cefores"
            val url_atual : String = urlpdf.pdf_cefores
            bundle.putString("tipopdf", tipopdf );
            bundle.putString("urlpdf", url_atual);


            findNavController().navigate(R.id.pdfVisualizador2, bundle)
        }
        binding.botaoView3.setOnClickListener {
            val bundle = Bundle()
            val tipopdf = "pdf_campussede_graduacao"
            val url_atual : String = urlpdf.pdf_graduacao
            bundle.putString("tipopdf", tipopdf );
            bundle.putString("urlpdf", url_atual );

            findNavController().navigate(R.id.pdfVisualizador2, bundle)
        }
        binding.botaoView5.setOnClickListener {
            val bundle = Bundle()
            val tipopdf = "pdf_campussede_lecampo"
            val url_atual : String = urlpdf.lecampo
            bundle.putString("tipopdf", tipopdf );
            bundle.putString("urlpdf", url_atual );

            findNavController().navigate(R.id.pdfVisualizador2, bundle)
        }
        binding.botaoView6.setOnClickListener {
            val bundle = Bundle()
            val tipopdf = "pdf_campusiturama_graduacao"
            val url_atual : String = urlpdf.iturama
            bundle.putString("tipopdf", tipopdf );
            bundle.putString("urlpdf", url_atual );

            findNavController().navigate(R.id.pdfVisualizador2, bundle)
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
