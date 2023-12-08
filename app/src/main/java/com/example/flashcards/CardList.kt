package com.example.flashcards

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.flashcards.model.Card

class CardList : Fragment() {

    private lateinit var descriptionTextView: TextView
    private lateinit var prevButton: Button
    private lateinit var nextButton: Button
    private lateinit var flipButton: Button
    private lateinit var viewModel: CardListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_card_list, container, false)
        prevButton = view.findViewById(R.id.prevButton)
        nextButton = view.findViewById(R.id.nextButton)
        flipButton = view.findViewById(R.id.flipButton)
        descriptionTextView = view.findViewById(R.id.descriptionTextView)

        return view;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CardListViewModel::class.java)
        viewModel.loadCards()
        viewModel.cardLiveData.observe(viewLifecycleOwner, { card ->
            descriptionTextView.text = card.deckDescription[0]?.first ?: ""
        })

        prevButton.setOnClickListener {
            viewModel.navigatePrevious()
        }

        nextButton.setOnClickListener {
            viewModel.navigateNext()
        }

        flipButton.setOnClickListener {
            viewModel.flipCard()
        }
    }

}