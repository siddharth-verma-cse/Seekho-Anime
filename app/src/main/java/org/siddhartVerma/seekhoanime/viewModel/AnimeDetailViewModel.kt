package org.siddhartVerma.seekhoanime.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.siddhartVerma.seekhoanime.data.model.AnimeItem
import org.siddhartVerma.seekhoanime.data.repository.AnimeRepository
import javax.inject.Inject

@HiltViewModel
class AnimeDetailViewModel @Inject constructor(
    private val repository: AnimeRepository
) : ViewModel() {

    private val _animeDetail = MutableLiveData<AnimeItem>()
    val animeDetail: LiveData<AnimeItem> = _animeDetail

    fun loadAnimeDetail(animeId: Int) {
        viewModelScope.launch {
            try {
                val detail = repository.getAnimeDetails(animeId)
                _animeDetail.postValue(detail)
            } catch (e: Exception) {
                // Handle error appropriately if needed
            }
        }
    }
}
