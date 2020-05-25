package com.ayova.catsapitest.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ayova.catsapitest.FullCatImage
import com.ayova.catsapitest.R
import com.ayova.catsapitest.models.RandomCats
import com.squareup.picasso.Picasso

class RandomCatsAdapter(private val randomCats: RandomCats?) : RecyclerView.Adapter<RandomCatsAdapter.MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cat_recycler_item, parent, false)
        return MainViewHolder(v)
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val catItem = randomCats?.get(position)
        Picasso.get().load(catItem?.url).into(holder.image)
        holder.image.setOnClickListener {

            var intent = Intent(holder.itemView.context, FullCatImage::class.java)
            intent.putExtra("id", catItem?.id)
            intent.putExtra("url", catItem?.url)
            holder.itemView.context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return randomCats?.size ?: 0
    }
    inner class MainViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val image: ImageView = v.findViewById(R.id.cat_rv_item_image)
    }
}