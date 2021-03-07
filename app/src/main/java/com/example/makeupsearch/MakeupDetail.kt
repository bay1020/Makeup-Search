package com.example.makeupsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.makeupsearch.databinding.ActivityMakeupDetailBinding
import com.example.makeupsearch.model.Post2
import org.json.JSONArray
import org.json.JSONObject

class MakeupDetail : AppCompatActivity() {
    private lateinit var binding: ActivityMakeupDetailBinding
    private val colorlist: MutableList<Post2> = mutableListOf()
    private lateinit var adapter: DetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMakeupDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val brand: String = intent.getStringExtra("brand").toString()
        val name: String = intent.getStringExtra("name").toString()
        val description: String = intent.getStringExtra("description").toString()
        val price: String = intent.getStringExtra("price").toString()
        val imagelink: String = intent.getStringExtra("imagelink").toString()
        val product_colors: String = intent.getStringExtra("product_colors").toString()

        var colorsasjson = JSONArray(product_colors)
        var colorsasobject = colorsasjson[0]

        Log.d("abc", colorsasjson.toString())
        Log.d("abc2", colorsasobject.toString())

        var size: Int = colorsasjson.length()


        for(r in 0 until size){
            val colorname: String = (colorsasjson[r] as JSONObject).get("colour_name").toString()
            val hexvalue: String = (colorsasjson[r] as JSONObject).get("hex_value").toString()

            colorlist.add(Post2(hexvalue, colorname))

        }

        createImage(imagelink)
        binding.textView2.text = "Brand: $brand\nName: $name\nDescription: $description\nPrice: $price\nColors:"

        binding.colorsRV.layoutManager = GridLayoutManager(applicationContext, 6, GridLayoutManager.VERTICAL, false)

        adapter = DetailAdapter(colorlist)
        binding.colorsRV.adapter = adapter

    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun createImage(imagelink: String){
        Glide.with(this).load(imagelink).into(binding.imageView2)
    }
}