package org.siddhartVerma.seekhoanime.data.api



import AnimeListResponse
import org.siddhartVerma.seekhoanime.data.model.AnimeDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("top/anime")
    suspend fun getTopAnime(@Query("page") page: Int): AnimeListResponse

    @GET("anime/{anime_id}")
    suspend fun getAnimeDetails(@Path("anime_id") animeId: Int): AnimeDetailResponse

}