package com.example.makeupsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.makeupsearch.databinding.ActivityMainBinding
import com.example.makeupsearch.model.Post
import com.example.makeupsearch.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "MainViewModel"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MakeupAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
//        GridLayoutManager

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

//        startActivity()

        button.setOnClickListener {
            val myBrand = brand_editText.text.toString()
            viewModel.getPost(myBrand)
            viewModel.myResponse.observe(this, Observer { response ->
                if (response.isSuccessful) {
                    val getResponseBody = response.body() ?: listOf()
                    // insert data
                    adapter = MakeupAdapter(getResponseBody)
                    binding.recyclerView.adapter = adapter
                }
            })
        }
    }
}