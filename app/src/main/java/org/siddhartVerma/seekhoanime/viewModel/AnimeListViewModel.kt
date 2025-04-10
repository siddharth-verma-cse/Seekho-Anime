package org.siddhartVerma.seekhoanime.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import org.siddhartVerma.seekhoanime.data.repository.AnimeRepository
import javax.inject.Inject

@HiltViewModel
class AnimeListViewModel @Inject constructor(
    private val repository: AnimeRepository
) : ViewModel() {

    // This will expose paged data to the Fragment
    val animePagingData = repository.getTopAnimePaged()
        .flow
        .cachedIn(viewModelScope)
}
