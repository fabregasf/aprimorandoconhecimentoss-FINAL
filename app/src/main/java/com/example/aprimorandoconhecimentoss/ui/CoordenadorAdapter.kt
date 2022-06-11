package com.example.aprimorandoconhecimentoss.ui

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aprimorandoconhecimentoss.R
import com.example.aprimorandoconhecimentoss.ui.entidades.Coordenacoes
import com.example.aprimorandoconhecimentoss.ui.entidades.CoordenacoesEnt


class CoordenadorAdapter(private val context: Activity, private val arrayDados: ArrayList<CoordenacoesEnt>)
    : ArrayAdapter<CoordenacoesEnt>(context, R.layout.item_coordenador, arrayDados){


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.item_coordenador, null)

        val imageView : ImageView = view.findViewById(R.id.profcoordenador)
        val nome : TextView = view.findViewById(R.id.nomeprof)
        val resumo : TextView = view.findViewById(R.id.resumoprof)

        imageView.setImageResource(arrayDados[position].foto)
        nome.text = arrayDados[position].professor
        resumo.text = arrayDados[position].resumo

        // retorna view gerada na funcao
        return view
    }



}
