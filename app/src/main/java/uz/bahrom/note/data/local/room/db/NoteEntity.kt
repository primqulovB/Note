package uz.bahrom.note.data.local.room.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import uz.bahrom.note.utils.NOTE_TABLE

@Entity(tableName = NOTE_TABLE)
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val noteId: Int = 0,
    @ColumnInfo(name = "note_title")
    val noteTitle: String = "",
    @ColumnInfo(name = "note_desc")
    val noteDesc: String = "",
    @ColumnInfo(name = "timestamp")
    val noteTime: String = "",
)
