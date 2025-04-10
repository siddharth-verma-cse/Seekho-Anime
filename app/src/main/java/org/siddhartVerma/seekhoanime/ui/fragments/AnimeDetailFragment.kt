package org.siddhartVerma.seekhoanime.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import org.siddhartVerma.seekhoanime.R
import org.siddhartVerma.seekhoanime.databinding.FragmentAnimeDetailBinding
import org.siddhartVerma.seekhoanime.viewModel.AnimeDetailViewModel


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


    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String){

        }
    }
}