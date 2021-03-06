package com.sopt27.praisewhale.collection.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sopt27.praisewhale.R
import com.sopt27.praisewhale.collection.data.CollectionPraise

class CardBoxAdapter (private val context : Context) : RecyclerView.Adapter<CardBoxViewHolder>(){
    var data = listOf<CollectionPraise>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardBoxViewHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.item_card_box_card,
            parent, false)

        return CardBoxViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CardBoxViewHolder, position: Int) {
        holder.onBind(data[position])
    }
}