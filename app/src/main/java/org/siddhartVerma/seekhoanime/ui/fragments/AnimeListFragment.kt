package org.siddhartVerma.seekhoanime.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.siddhartVerma.seekhoanime.R
import org.siddhartVerma.seekhoanime.databinding.FragmentAnimeListBinding
import org.siddhartVerma.seekhoanime.ui.adapter.AnimeLoadStateAdapter

import org.siddhartVerma.seekhoanime.ui.adapter.AnimePagingAdapter
import org.siddhartVerma.seekhoanime.viewModel.AnimeListViewModel


@AndroidEntryPoint
class AnimeListFragment : Fragment() {

    private var _binding: FragmentAnimeListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AnimeListViewModel by viewModels()
    private lateinit var animeAdapter: AnimePagingAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnimeListBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animeAdapter = AnimePagingAdapter { animeItem ->
            val action = AnimeListFragmentDirections
                .actionAnimeListFragmentToAnimeDetailFragment(animeItem.malId!!)
            findNavController().navigate(action)
        }

        binding.recyclerView.adapter = animeAdapter.withLoadStateHeaderAndFooter(
            header = AnimeLoadStateAdapter { animeAdapter.retry() },
            footer = AnimeLoadStateAdapter { animeAdapter.retry() }
        )

        lifecycleScope.launch {
            viewModel.animePagingData.collectLatest { pagingData ->
                animeAdapter.submitData(pagingData)
            }
        }
    }


    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) {

        }
    }
}