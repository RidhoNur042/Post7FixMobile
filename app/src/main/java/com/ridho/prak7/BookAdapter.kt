package com.ridho.prak7

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ridho.prak7.databinding.ItemBookBinding

class BookAdapter(private val list: List<Book>) :
    RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemBookBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBookBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = list[position]

        holder.binding.txtTitle.text = book.title
        holder.binding.txtDate.text = book.date

        // Load gambar dari drawable
        Glide.with(holder.itemView.context)
            .load(book.imageResId)
            .into(holder.binding.imgBook)   // pastikan ID ImageView = imgBook

        // klik item → DetailActivity
        holder.itemView.setOnClickListener {
            val ctx = holder.itemView.context
            val intent = Intent(ctx, DetailActivity::class.java)

            intent.putExtra("title", book.title)
            intent.putExtra("date", book.date)
            intent.putExtra("description", book.description)
            intent.putExtra("pages", book.pages)
            intent.putExtra("imageResId", book.imageResId)

            ctx.startActivity(intent)
        }
    }

    override fun getItemCount() = list.size
}
