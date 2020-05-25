package com.ayova.catsapitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_full_cat_image.*

class FullCatImage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_cat_image)

        val bundle = intent.extras
        val id = bundle?.getString("id")
        val url = bundle?.getString("url")

        setFullImageView(id!!, url!!)
    }

    private fun setFullImageView(catId: String, catUrl: String) {
        fullimage_id.text = catId
        fullimage_url.text = catUrl
        Picasso.get().load(catUrl).into(fullimage_image)
    }
}
