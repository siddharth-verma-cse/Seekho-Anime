import com.google.gson.annotations.SerializedName

data class AnimeListResponse(
    @SerializedName("data") val animeList: List<AnimeItem>,

    @SerializedName("pagination") val pagination: Pagination
)

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

data class Genre(
    @SerializedName("name") val name: String
)

data class Trailer(
    @SerializedName("url") val url: String?,

    @SerializedName("youtube_id") val youtubeId: String?
)

data class Images(
    @SerializedName("jpg") val jpg: Jpg
)

data class Jpg(
    @SerializedName("image_url") val imageUrl: String
)

data class Pagination(
    @SerializedName("has_next_page") val hasNextPage: Boolean,

    @SerializedName("current_page") val currentPage: Int
)
