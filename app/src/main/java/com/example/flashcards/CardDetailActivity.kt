package com.example.flashcards

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.flashcards.databinding.ActivityCardDetailBinding
import com.example.flashcards.model.Card
import com.example.nikerunningshoes.data.Datasource

class CardDetailActivity : AppCompatActivity() {

    private var flipped = false
    private lateinit var cardsList: List<Card>
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityCardDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_card_detail)

        cardsList = Datasource(this).loadCards()

        binding.card = cardsList[currentIndex]

        binding.prevButton.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex--
                updateCardDetails(binding,  false)
            }
        }

        binding.nextButton.setOnClickListener {
            if (currentIndex < cardsList.size - 1) {
                currentIndex++
                updateCardDetails(binding,  false)
            }
        }

        binding.flipButton.setOnClickListener {
            updateCardDetails(binding, true)
        }
    }

    private fun updateCardDetails(
        binding: ActivityCardDetailBinding,
        flipCard: Boolean
    ) {
        val card = cardsList[currentIndex].copy()

        if (currentIndex >= 0 && currentIndex < card.deckDescription.size) {

            if (flipCard && !flipped) {
                binding.descriptionTextView.text = card.deckDescription[currentIndex]?.second
                flipped = true

            } else if (flipCard && flipped) {
                binding.descriptionTextView.text = card.deckDescription[currentIndex]?.first
                flipped = false
            }
            else {
                binding.descriptionTextView.text = card.deckDescription[currentIndex]?.first
            }
        }
    }
}