package com.williamzabot.marvelapp.data.model

import com.williamzabot.marvelapp.presentation.model.Comic

data class Result(
    val characters: Characters,
    val dates: List<Date>,
    val description: String?,
    val diamondCode: String,
    val digitalId: Int,
    val ean: String,
    val format: String,
    val id: Int,
    val images: List<Image>,
    val isbn: String,
    val issn: String,
    val issueNumber: Int,
    val modified: String,
    val pageCount: Int,
    val prices: List<Price>,
    val resourceURI: String,
    val textObjects: List<TextObject>,
    val thumbnail: Thumbnail,
    val title: String,
    val upc: String,
    val urls: List<Url>,
    val variantDescription: String
)

fun Result.toComic(): Comic {
    val image = if (images.isNotEmpty()){
        "${images[0].path}.${images[0].extension}"
    }else{
        null
    }
    return Comic(
        id, title, image,
        "${thumbnail.path}.${thumbnail.extension}",
        prices[0].price, description
    )
}