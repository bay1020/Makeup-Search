package com.example.makeupsearch

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.makeupsearch.databinding.MakeupInfoLayoutBinding
import com.example.makeupsearch.model.MakeupInformation
import com.google.gson.Gson

private const val TAG = "MakeupAdapter"
class MakeupAdapter(private val data: List<MakeupInformation>): RecyclerView.Adapter<MakeupAdapter.MakeupViewHolder>(){
    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakeupAdapter.MakeupViewHolder {
        val binding: MakeupInfoLayoutBinding = MakeupInfoLayoutBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        mContext = parent.context
        return MakeupViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MakeupAdapter.MakeupViewHolder, position: Int) {
        val currentItem = data[position]
        Log.d(TAG, "onBindViewHolder: get data is $currentItem")
        holder.onBind(currentItem)
    }

    inner class MakeupViewHolder(val binding: MakeupInfoLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(r: MakeupInformation){
            Glide.with(mContext).load(r.image_link).into(binding.imageView)


            binding.textView.text =  "Name: " + r.name + "\nPrice: " + r.price

            var colors = r.product_colors.toString()
            Log.d("aaa", colors)
            Log.d("aaa", colors)
            val colors2 = Gson().toJson(r.product_colors)
            Log.d("aaa2", colors2)


            binding.root.setOnClickListener {


                val intent = Intent(mContext, MakeupDetail::class.java). apply{
                    putExtra ("brand", r.brand)
                    putExtra ("name", r.name)
                    putExtra ("price", r.price)
                    putExtra ("description", r.description)
                    putExtra("imagelink", r.image_link)
                    putExtra("product_colors", colors2)
                }


                startActivity(mContext, intent, null)
            }
        }
    }

}
