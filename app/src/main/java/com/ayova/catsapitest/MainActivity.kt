package com.ayova.catsapitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.ayova.catsapitest.adapter.RandomCatsAdapter
import com.ayova.catsapitest.api.CatsApi
import com.ayova.catsapitest.models.RandomCats
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val TAG = "miapp"
    private var allCats: RandomCats = RandomCats()
    private var randomCatAdapter: RandomCatsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CatsApi.initService()
        getRandomImages()
        setRecyclerAdapter()
        main_floating_update.setOnClickListener{ getRandomImages() }

    }

    private fun setRecyclerAdapter(){
        main_rv.layoutManager = GridLayoutManager(this, 2)
        randomCatAdapter = RandomCatsAdapter(allCats)
        main_rv.adapter = randomCatAdapter
    }

    private fun getRandomImages() {
        val call = CatsApi.service.getRandImage()
        call.enqueue(object : Callback<RandomCats> {
            override fun onResponse(call: Call<RandomCats>, response: Response<RandomCats>) {
                val body = response.body()
                if (response.isSuccessful && body != null) {
                    allCats.clear()
                    allCats.addAll(body)
                    // log of all cats received
                    Log.v(TAG, allCats.toString())
                    randomCatAdapter?.notifyDataSetChanged()
                } else {
                    Log.e(TAG, response.errorBody()!!.string())
                }
            }
            override fun onFailure(call: Call<RandomCats>, t: Throwable) {
                Log.e(TAG, t.message!!)
            }
        })
    }
}
