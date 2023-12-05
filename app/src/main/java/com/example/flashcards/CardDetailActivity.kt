package com.example.flashcards

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.flashcards.databinding.ActivityCardDetailBinding
import com.example.flashcards.model.Card

class CardDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_user_detail)

        val binding : ActivityCardDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_card_detail)

        val selectedShoe = intent.getSerializableExtra("CARD_KEY") as Card
        binding.card = selectedShoe

    }
}