package uz.bahrom.note.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.bahrom.note.R
import uz.bahrom.note.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            imMyTg?.setOnClickListener {
                openTelegram("Primqulov_Bahrom")
            }
            imGitaTg?.setOnClickListener {
                openTelegram("gitauz")
            }
            imGitaInsta?.setOnClickListener {
                openInstagram("gita.uzofficial")
            }
            imGitaYoutube?.setOnClickListener {
                openYoutube("UCjegZuzSYR4Ew5NDirQk_mg")
            }
        }
    }

    private fun openTelegram(name: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/$name"))
        startActivity(intent)
    }

    private fun openInstagram(name: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/$name"))
        startActivity(intent)
    }

    private fun openYoutube(name: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/$name"))
        startActivity(intent)
    }
}