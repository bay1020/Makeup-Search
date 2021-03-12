    package com.example.makeupsearch.model

    //import java.io.Serializable

    data class MakeupInformation(
        val brand: String,
        val name: String,
        val price: Float,
        val image_link: String,
        val description: String,
        val product_link: String,
        val product_colors: List<ProductColorInformation>
    )

    data class ProductColorInformation(
        val hex_value: String,
        val colour_name: String
    )