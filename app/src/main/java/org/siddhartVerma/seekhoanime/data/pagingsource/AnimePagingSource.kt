package org.siddhartVerma.seekhoanime.data.pagingsource

import AnimeItem
import androidx.paging.PagingSource
import androidx.paging.PagingState
import org.siddhartVerma.seekhoanime.data.api.ApiService

class AnimePagingSource(
    private val apiService: ApiService
) : PagingSource<Int, AnimeItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, AnimeItem> {
        return try {
            val page = params.key ?: 1
            val response = apiService.getTopAnime(page)

            LoadResult.Page(
                data = response.animeList,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.pagination.hasNextPage) page + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, AnimeItem>): Int? = null
}
