package uz.bahrom.note.domain.repository

import uz.bahrom.note.data.local.room.db.NoteDao
import uz.bahrom.note.data.local.room.db.NoteEntity
import javax.inject.Inject

class Repository @Inject constructor(
    private val dao: NoteDao,
) {

    fun saveNote(note: NoteEntity) = dao.inserNote(note)
    fun updateNote(note: NoteEntity) = dao.updateNote(note)
    fun deleteNote(note: NoteEntity) = dao.deleteNote(note)
    fun getNote(id : Int) : NoteEntity = dao.getNote(id)
    fun getAllNotes() = dao.getAllNotes()

}