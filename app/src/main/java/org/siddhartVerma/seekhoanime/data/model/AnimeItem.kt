package org.siddhartVerma.seekhoanime.data.model

import Genre
import Images
import Trailer
import com.google.gson.annotations.SerializedName

data class AnimeItem(
    @SerializedName("mal_id") val malId: Int? = null,

    @SerializedName("title") val title: String? = null,

    @SerializedName("episodes") val episodes: Int? = null,

    @SerializedName("score") val score: Double? = null,

    @SerializedName("synopsis") val synopsis: String? = null,

    @SerializedName("genres") val genres: List<Genre> = emptyList(),

    @SerializedName("trailer") val trailer: Trailer? = null,

    @SerializedName("images") val images: Images? = null
)
