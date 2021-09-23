package com.challenge.homefeeds.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HomeFeedsPage(
    val page: Page
)

data class Page(
    val cards: ArrayList<FeedCardItem>
)

data class FeedCardItem(
    @SerializedName("card_type")
    @Expose
    val cardType: String,
    @SerializedName("card")
    @Expose
    val card: Card
)

data class Card(
    val value: String,
    val attributes: AttributeItem,
    val title: Text,
    val description: Text,
    val image: Image
)

data class Text(
    val value: String,
    val attributes: AttributeItem,
)

data class Image(
    val url: String,
    val size: ImageSize
)

data class AttributeItem(
    @SerializedName("text_color")
    @Expose
    val textColor: String,
    val font: FontSizeItem
)

data class FontSizeItem(
    val size: Int
)

data class ImageSize(
    val width: Int,
    val height: Int
)