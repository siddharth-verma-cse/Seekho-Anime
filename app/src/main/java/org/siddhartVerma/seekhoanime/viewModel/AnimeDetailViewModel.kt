package org.siddhartVerma.seekhoanime.viewModel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.siddhartVerma.seekhoanime.data.repository.AnimeRepository
import javax.inject.Inject

@HiltViewModel
class AnimeDetailViewModel @Inject constructor(
    repository: AnimeRepository
) : ViewModel() {


}