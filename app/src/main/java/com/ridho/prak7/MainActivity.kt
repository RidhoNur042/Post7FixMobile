package com.ridho.prak7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ridho.prak7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val books = listOf(
            Book(
                "Harry Potter and the Sorcerer's Stone",
                "June 26, 1997",
                "Harry discovers he is a wizard...",
                223,
                R.drawable.harrypotter
            ),
            Book(
                "Harry Potter and the Chamber of Secrets",
                "July 2, 1998",
                "The second year of Harry at Hogwarts...",
                251,
                R.drawable.harrypotter
            )
        )


        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = BookAdapter(books)
    }
}
