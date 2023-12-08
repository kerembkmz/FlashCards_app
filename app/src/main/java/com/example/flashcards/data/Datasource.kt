package com.example.nikerunningshoes.data

import android.content.Context
import com.example.flashcards.R
import com.example.flashcards.model.Card


class Datasource(val context: Context) {

    fun getCardNameList(): Array<String> {
        return context.resources.getStringArray(R.array.card_names_array)
    }


    fun loadCards(): List<Card> {
        val namesList = getCardNameList()

        val cards = mutableListOf<Card>()
        for (i in 0..9) {
            val deckDescriptionMap = HashMap<Int, Pair<String, String>>()
            deckDescriptionMap[0] = "Who painted the Mona Lisa?" to "Leonardo da Vinci"
            deckDescriptionMap[1] = "What is the powerhouse of the cell?" to "Mitochondria"
            deckDescriptionMap[2] = "hello" to "merhaba"

            val card = Card(namesList[i], i.toString(), deckDescriptionMap)
            cards.add(card)
        }

        return cards
    }
}