import com.google.gson.annotations.SerializedName
import org.siddhartVerma.seekhoanime.data.model.AnimeItem

data class AnimeListResponse(
    @SerializedName("data") val animeList: List<AnimeItem>,

    @SerializedName("pagination") val pagination: Pagination
)

data class Genre(
    @SerializedName("name") val name: String
)

data class Trailer(
    @SerializedName("url") val url: String?,

    @SerializedName("youtube_id") val youtubeId: String?
)



data class Images(
    @SerializedName("jpg") val jpg: Jpg? = null
)

data class Jpg(
    @SerializedName("image_url") val image_url: String? = null
)

data class Pagination(
    @SerializedName("has_next_page") val hasNextPage: Boolean,

    @SerializedName("current_page") val currentPage: Int
)
