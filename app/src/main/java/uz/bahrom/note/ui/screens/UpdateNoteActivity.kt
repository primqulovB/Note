package uz.bahrom.note.ui.screens

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import uz.bahrom.note.databinding.ActivityUpdateNoteBinding
import uz.bahrom.note.data.local.room.db.NoteEntity
import uz.bahrom.note.ui.adapter.NoteAdapter
import uz.bahrom.note.domain.repository.Repository
import uz.bahrom.note.utils.Constants.BUNDLE_NOTE_ID
import java.text.SimpleDateFormat
import java.util.Date
import javax.inject.Inject

@AndroidEntryPoint
class UpdateNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateNoteBinding

    @Inject
    lateinit var repository: Repository

    @Inject
    lateinit var noteAdapter: NoteAdapter

    @Inject
    lateinit var note: NoteEntity

    private var noteId = 0
    private var defaultTitle = ""
    private var defaultDesc = ""


    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras?.let {
            noteId = it.getInt(BUNDLE_NOTE_ID)
        }

        binding.apply {
            defaultTitle = repository.getNote(noteId).noteTitle
            defaultDesc = repository.getNote(noteId).noteDesc

            edtTitle.setText(defaultTitle)
            edtDesc.setText(defaultDesc)

            btnDelete.setOnClickListener {
                note = NoteEntity(noteId, defaultTitle, defaultDesc)
                repository.deleteNote(note)
                finish()
            }

            btnSave.setOnClickListener {
                val title = edtTitle.text.toString()
                val desc = edtDesc.text.toString()
                if (title.isNotEmpty() && desc.isNotEmpty()) {
                    val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                    val currentDataAndTime: String = sdf.format(Date())

                    note = NoteEntity(noteId, title, desc, currentDataAndTime)
                    repository.updateNote(note)
                    finish()
                } else {
                    Snackbar.make(it, "Title and Description cannot be Empty", Snackbar.LENGTH_LONG)
                        .show()
                }
            }
        }

    }
}