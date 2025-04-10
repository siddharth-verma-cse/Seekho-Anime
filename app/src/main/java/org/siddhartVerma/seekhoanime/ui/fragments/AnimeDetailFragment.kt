package org.siddhartVerma.seekhoanime.ui.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

import org.siddhartVerma.seekhoanime.databinding.FragmentAnimeDetailBinding
import org.siddhartVerma.seekhoanime.viewModel.AnimeDetailViewModel
import androidx.core.net.toUri


@AndroidEntryPoint
class AnimeDetailFragment : Fragment() {
    private var _binding: FragmentAnimeDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AnimeDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnimeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val animeId = arguments?.let {
            AnimeDetailFragmentArgs.fromBundle(it).animeId
        } ?: return

        viewModel.loadAnimeDetail(animeId)

        viewModel.animeDetail.observe(viewLifecycleOwner) { anime ->
            binding.apply {
                tvTitle.text = anime.title
                tvEpisodes.text = "Episodes: ${anime.episodes ?: "N/A"}"
                tvScore.text = "Rating: ${anime.score ?: "N/A"}"
                tvSynopsis.text = anime.synopsis ?: "No synopsis available"

                Glide.with(this@AnimeDetailFragment)
                    .load(anime.images.jpg.imageUrl)
                    .into(ivPoster)

                btnWatchTrailer.isVisible = !anime.trailer?.url.isNullOrBlank()
                btnWatchTrailer.setOnClickListener {
                    anime.trailer?.url?.let { url ->
                        val intent = Intent(Intent.ACTION_VIEW, url.toUri())
                        startActivity(intent)
                    }
                }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String){

        }
    }
}