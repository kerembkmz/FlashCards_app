package com.example.flashcards


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flashcards.model.Card



class CardListViewModel : ViewModel() {
    private val _cardLiveData = MutableLiveData<Card>()
    val cardLiveData: LiveData<Card> = _cardLiveData

    private val cardsList: MutableList<Card> = mutableListOf() // Holds generated cards

    private var currentIndex = 0
    private var flipped = false

    fun loadCards() {
        // Simulate loading cards with dummy data similar to Datasource
        val deckDescriptionMap = HashMap<Int, Pair<String, String>>()
        deckDescriptionMap[0] = "Who painted the Mona Lisa?" to "Leonardo da Vinci"
        deckDescriptionMap[1] = "What is the powerhouse of the cell?" to "Mitochondria"
        deckDescriptionMap[2] = "hello" to "merhaba"

        val card = Card("Card Title", "1", deckDescriptionMap) // Example card
        cardsList.add(card)

        _cardLiveData.value = card // Set the initial card
    }

    fun navigatePrevious() {
        if (currentIndex > 0) {
            currentIndex--
            updateCardDetails()
        }
    }

    fun navigateNext() {
        if (currentIndex < cardsList.size - 1) {
            currentIndex++
            updateCardDetails()
        }
    }

    fun flipCard() {
        flipped = !flipped
        updateCardDetails()
    }

    private fun updateCardDetails() {
        val card = cardsList[currentIndex]

        if (currentIndex >= 0 && currentIndex < card.deckDescription.size) {
            val updatedDescription = if (flipped) {
                card.deckDescription[currentIndex]?.second to card.deckDescription[currentIndex]?.first
            } else {
                card.deckDescription[currentIndex]?.first to card.deckDescription[currentIndex]?.second
            }

            val updatedDeck = HashMap<Int, Pair<String, String>>()
            updatedDeck[currentIndex] = updatedDescription as Pair<String, String>

            val updatedCard = Card(card.name, card.id, updatedDeck)
            _cardLiveData.value = updatedCard
        }
    }
}