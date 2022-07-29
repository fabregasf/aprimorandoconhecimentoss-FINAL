package com.example.aprimorandoconhecimentoss.ui.muralinfo

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.util.Log.INFO
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.example.aprimorandoconhecimentoss.R
import com.example.aprimorandoconhecimentoss.databinding.FragmentMuralinformacoesBinding
import kotlinx.android.synthetic.main.listview_mural.view.*
import java.util.logging.Level.INFO

class MuralInformacoes : Fragment(), AdapterView.OnItemClickListener {

    private var _binding: FragmentMuralinformacoesBinding? = null
    private val binding get() = _binding!!


    @SuppressLint("ResourceType")
    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_muralinformacoes, container, false)

        val arrayNoticias = arrayOf<String>("feira de ecologia","feira de ecologia começando", "eventos da uftm")

        val lsView: ListView = view?.findViewById(R.id.listview_mural_id)
        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter<String>(requireContext(),R.layout.listview_mural, arrayNoticias)
        lsView.adapter = arrayAdapter

        return view
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("Not yet implemented")
    }

}

private class MuralAdapter<T>(private val context: Context?, private val noticia: ArrayList<MuralEnt>)
    : BaseAdapter() {

    private val mInflator: LayoutInflater

    init {
        this.mInflator = LayoutInflater.from(context)
    }
    override fun getCount(): Int {
        return noticia.size
    }

    override fun getItem(position: Int): Any {
        return noticia[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?,  parent: ViewGroup?): View? {
        val view: View?
        val vh: ListRowHolder
        if (convertView == null) {
            view = this.mInflator.inflate(R.layout.fragment_muralinformacoes, parent, false)
            vh = ListRowHolder(view)
            view.tag = vh
        } else {
            view = convertView
            vh = view.tag as ListRowHolder
        }

        /* Dados do banco aqui.. */
        vh.label.text = noticia[position].titulo
        vh.texto.text = noticia[position].texto


        return view
    }


}

private class ListRowHolder(row: View?) {
    var label: TextView
    var texto: TextView


    init {
        this.label = row!!.findViewById(R.id.titulo) as TextView
        this.texto = row.findViewById(R.id.texto) as TextView

    }
}