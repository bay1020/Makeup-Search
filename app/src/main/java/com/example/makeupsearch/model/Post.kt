package com.example.makeupsearch.model

//import java.io.Serializable

data class Post(
    val brand: String,
    val name: String,
    val price: Float,
    val image_link: String,
    val description: String,
    val product_link: String,
    val product_colors: List<Post2>
)

data class Post2(
    val hex_value: String,
    val colour_name: String
)