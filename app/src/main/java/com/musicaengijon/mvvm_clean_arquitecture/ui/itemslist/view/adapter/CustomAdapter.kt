package com.musicaengijon.mvvm_clean_arquitecture.ui.itemslist.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.musicaengijon.mvvm_clean_arquitecture.R
import com.musicaengijon.mvvm_clean_arquitecture.R.layout
import com.musicaengijon.mvvm_clean_arquitecture.model.Item
import com.musicaengijon.mvvm_clean_arquitecture.ui.itemslist.view.adapter.CustomAdapter.ViewHolder

class CustomAdapter(
    private val items: List<Item>,
    private val listener: (Item) -> Unit
) : RecyclerView.Adapter<ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { listener(item)}


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(layout.row_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val example = view.findViewById(R.id.rv_textView) as TextView
        fun bind(item: Item) {
            example.text = item.example
        }
    }
}