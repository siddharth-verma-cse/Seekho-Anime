package org.siddhartVerma.seekhoanime.ui.adapter

import AnimeItem
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.siddhartVerma.seekhoanime.R
import org.siddhartVerma.seekhoanime.databinding.AnimeItemBinding

class AnimePagingAdapter(
    private val onAnimeClick: (AnimeItem) -> Unit
) : PagingDataAdapter<AnimeItem, AnimePagingAdapter.AnimeViewHolder>(AnimeDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val binding = AnimeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val animeItem = getItem(position)
        if (animeItem != null) {
            holder.bind(animeItem)
        }
    }

    inner class AnimeViewHolder(private val binding: AnimeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(animeItem: AnimeItem) {
            binding.apply {
                tvTitle.text = animeItem.title
                tvEpisodes.text = "Episodes: ${animeItem.episodes ?: "N/A"}"
                tvScore.text = "Rating: ${animeItem.score ?: "N/A"}"

                Glide.with(ivPoster.context)
                    .load(animeItem.images.jpg.imageUrl)
                    .placeholder(R.drawable.baseline_broken_image_24)
                    .into(ivPoster)

                root.setOnClickListener {
                    onAnimeClick(animeItem)
                }
            }
        }
    }

    class AnimeDiffCallback : DiffUtil.ItemCallback<AnimeItem>() {
        override fun areItemsTheSame(oldItem: AnimeItem, newItem: AnimeItem): Boolean {
            return oldItem.malId == newItem.malId
        }

        override fun areContentsTheSame(oldItem: AnimeItem, newItem: AnimeItem): Boolean {
            return oldItem == newItem
        }
    }
}
