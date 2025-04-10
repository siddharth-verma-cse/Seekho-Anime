package org.siddhartVerma.seekhoanime.data.api



import AnimeListResponse
import org.siddhartVerma.seekhoanime.data.model.AnimeItem
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("top/anime")
    suspend fun getTopAnime(@Query("page") page: Int): AnimeListResponse

    @GET("anime/{id}")
    suspend fun getAnimeDetails(@Path("id") animeId: Int): AnimeItem

}