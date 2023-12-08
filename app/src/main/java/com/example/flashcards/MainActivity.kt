package com.example.flashcards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.nikerunningshoes.adapter.CardAdapter
import com.example.nikerunningshoes.data.Datasource

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val cards = Datasource(this).loadCards()

//        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
//        recyclerView.adapter = CardAdapter(cards)

    }
    override fun onSupportNavigateUp(): Boolean {
        navController = findNavController(R.id.nav_host_fragment)
        return super.onSupportNavigateUp() || super.onSupportNavigateUp()
    }
}
