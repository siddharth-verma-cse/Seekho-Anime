package org.siddhartVerma.seekhoanime.viewModel

import AnimeItem
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.siddhartVerma.seekhoanime.data.repository.AnimeRepository
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel  @Inject constructor(
    private val repository: AnimeRepository
) : ViewModel() {

    val animeList = repository.getTopAnimePaged().flow.cachedIn(viewModelScope)

    private val _animeDetail = MutableLiveData<AnimeItem>()
    val animeDetail: LiveData<AnimeItem> = _animeDetail

    fun loadAnimeDetail(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _animeDetail.value = repository.getAnimeDetails(id)
        }
    }
}