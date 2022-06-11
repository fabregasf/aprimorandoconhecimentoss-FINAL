package com.example.aprimorandoconhecimentoss.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.marginTop
import androidx.recyclerview.widget.RecyclerView
import com.example.aprimorandoconhecimentoss.R
import com.example.aprimorandoconhecimentoss.ui.coordenacoes.Coordenacoes


class ImageAdapter(context: Context, items: ArrayList<Dados>) : BaseAdapter() {

    private var mContext: Context? = context
    private var itemsClass: ArrayList<Dados>? = null

    init {
        this.itemsClass = items
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var holder: ViewHolder?
        var view: View? = convertView

        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.linha_coordenacoes, null)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            holder = view.tag as? ViewHolder
        }

        val item = getItem(position) as Dados
        holder?.name?.text = item.name
        holder?.img?.setImageResource(item.image)

        return view!!
    }

    class Dados(name: String,  image: Int) {

        var name: String = ""
        var image: Int = 0

        init {
            this.name = name
            this.image = image
        }

    }
    // Faz o link com a View
    private class ViewHolder(view: View) {

        var name: TextView? = null
        var img: ImageView? = null

        init {
            this.name = view.findViewById(R.id.textView_item)
            this.img = view.findViewById(R.id.imageview_coordenacao)
        }

    }

    override fun getCount(): Int {
        return this.itemsClass?.size!!
    }

    override fun getItem(position: Int): Any {
        return this.itemsClass?.get(position)!!
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


}