package org.siddhartVerma.seekhoanime.data.repository


import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import org.siddhartVerma.seekhoanime.data.api.ApiService
import org.siddhartVerma.seekhoanime.data.model.AnimeItem
import org.siddhartVerma.seekhoanime.data.pagingsource.AnimePagingSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AnimeRepository @Inject constructor(
    private val apiService: ApiService
) {
    fun getTopAnimePaged(): Pager<Int, AnimeItem> {
        return Pager(
            config = PagingConfig(pageSize = 25),
            pagingSourceFactory = { AnimePagingSource(apiService) }
        )
    }

    suspend fun getAnimeDetails(id: Int): AnimeItem? {
        Log.d("TAG", "getAnimeDetailsID:  $id" )
        return apiService.getAnimeDetails(id).data
    }
}
