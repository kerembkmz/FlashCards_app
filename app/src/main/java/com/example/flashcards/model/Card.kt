package com.example.flashcards.model

import java.io.Serializable

data class Card(val name: String, val id: String, val deckDescription: HashMap<Int, Pair<String, String>>) : Serializable {}