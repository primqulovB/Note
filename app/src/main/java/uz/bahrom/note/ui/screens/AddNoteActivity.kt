package uz.bahrom.note.ui.screens

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import uz.bahrom.note.databinding.ActivityAddNoteBinding
import uz.bahrom.note.data.local.room.db.NoteEntity
import uz.bahrom.note.domain.repository.Repository
import java.text.SimpleDateFormat
import java.util.Date
import javax.inject.Inject

@AndroidEntryPoint
class AddNoteActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddNoteBinding

    @Inject
    lateinit var repository: Repository

    @Inject
    lateinit var note: NoteEntity

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnSave.setOnClickListener {
                val title = edtTitle.text.toString()
                val desc = edtDesc.text.toString()
                if (title.isNotEmpty() && desc.isNotEmpty()) {

                    val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                    val currentDataAndTime: String = sdf.format(Date())

                    note = NoteEntity(0, title, desc, currentDataAndTime)
                    repository.saveNote(note)
                    finish()
                } else {
                    Snackbar.make(it, "Title and Description cannot be Empty", Snackbar.LENGTH_LONG)
                        .show()
                }
            }
        }

    }
}