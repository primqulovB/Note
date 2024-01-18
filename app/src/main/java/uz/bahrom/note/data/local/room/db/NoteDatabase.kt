package uz.bahrom.note.data.local.room.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NoteEntity::class], version = 2)
abstract class NoteDatabase : RoomDatabase(){
    abstract  fun noteDoa():NoteDao
}