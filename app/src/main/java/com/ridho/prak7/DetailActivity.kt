package com.ridho.prak7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.ridho.prak7.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data
        val title = intent.getStringExtra("title")
        val date = intent.getStringExtra("date")
        val description = intent.getStringExtra("description")
        val pages = intent.getIntExtra("pages", 0)
        val imageResId = intent.getIntExtra("imageResId", 0)

        // Pasang data ke view
        binding.apply {
            detailTitle.text = title
            detailDate.text = date
            detailDesc.text = description
            detailPages.text = "$pages pages"

            Glide.with(this@DetailActivity)
                .load(imageResId)
                .into(imgDetailBook)
        }
    }
}
