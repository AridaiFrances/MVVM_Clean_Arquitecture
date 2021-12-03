package com.example.mvvm_clean_arquitecture.ui.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_clean_arquitecture.R
import com.example.mvvm_clean_arquitecture.model.Item

class CustomAdapter : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private var transactions: List<Item> = ArrayList()
    private lateinit var context: Context
    fun RecyclerAdapter(transactions: List<Item>, context: Context) {
        this.transactions = transactions
        this.context = context
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = transactions[position]
        holder.bind(item, context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.row_item, parent, false))
    }

    override fun getItemCount(): Int {
        return transactions.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val example = view.findViewById(R.id.rv_textView) as TextView
        fun bind(item: Item, context: Context) {
            example.text = item.example
        }
    }
}