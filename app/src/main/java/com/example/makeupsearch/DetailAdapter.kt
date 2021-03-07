package com.example.makeupsearch

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.makeupsearch.databinding.ColorsDisplayBinding
import com.example.makeupsearch.model.Post2
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject

private const val TAG = "DetailAdapter"
class DetailAdapter(private val data: List<Post2>): RecyclerView.Adapter<DetailAdapter.DetailViewHolder>(){
    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailAdapter.DetailViewHolder {
        val binding: ColorsDisplayBinding = ColorsDisplayBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        mContext = parent.context
        return DetailViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: DetailAdapter.DetailViewHolder, position: Int) {
        val currentItem = data[position]
//        Log.d(TAG, "onBindViewHolder: get data is $currentItem")
        holder.onBind(currentItem)
    }

    inner class DetailViewHolder(val binding: ColorsDisplayBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(r: Post2){
            Log.d("color", r.hex_value)
            Log.d("color2", r.colour_name)

            binding.color.setBackgroundColor(Color.parseColor(r.hex_value))


        }
    }

}
