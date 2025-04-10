package org.siddhartVerma.seekhoanime.data.model

import Genre
import Images
import Trailer
import com.google.gson.annotations.SerializedName

data class AnimeItem(
    @SerializedName("mal_id") val malId: Int,

    @SerializedName("title") val title: String,

    @SerializedName("episodes") val episodes: Int?,

    @SerializedName("score") val score: Double?,

    @SerializedName("synopsis") val synopsis: String?,

    @SerializedName("genres") val genres: List<Genre>,

    @SerializedName("trailer") val trailer: Trailer?,

    @SerializedName("images") val images: Images
)
