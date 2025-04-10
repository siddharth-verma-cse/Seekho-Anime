package org.siddhartVerma.seekhoanime.data.model

import com.google.gson.annotations.SerializedName

class AnimeDetailResponse {
    @SerializedName("data" ) var data : AnimeItem? = AnimeItem()
}

