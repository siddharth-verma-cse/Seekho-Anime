package org.siddhartVerma.seekhoanime.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dagger.hilt.android.AndroidEntryPoint
import org.siddhartVerma.seekhoanime.R
import org.siddhartVerma.seekhoanime.databinding.ActivityMainBinding
import org.siddhartVerma.seekhoanime.ui.fragments.AnimeListFragment

@AndroidEntryPoint
class AnimeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // Assuming you're using ViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge() // Optional, for full-screen layouts

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set window insets to avoid overlapping system UI
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}