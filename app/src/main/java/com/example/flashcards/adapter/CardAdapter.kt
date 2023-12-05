package com.example.nikerunningshoes.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.flashcards.CardDetailActivity
import com.example.flashcards.R
import com.example.flashcards.model.Card


class CardAdapter(val dataset:List<Card>): RecyclerView.Adapter<CardAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        val nameView: TextView = view.findViewById(R.id.nameView)
        val profileDescView: TextView = view.findViewById(R.id.profileDescView)
        private lateinit var card:Card

        init{
            view.setOnClickListener{
                val context = itemView.context
                val showUserIntent = Intent(context, CardDetailActivity::class.java)
                showUserIntent.putExtra("CARD_KEY", card)
                context.startActivity(showUserIntent)

            }
        }

        fun bind(card:Card){
            this.card = card
            nameView.text = card.name
            profileDescView.text = card.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemLayout = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ItemViewHolder(itemLayout)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val shoe = dataset[position]
        holder.bind(shoe)
    }
}