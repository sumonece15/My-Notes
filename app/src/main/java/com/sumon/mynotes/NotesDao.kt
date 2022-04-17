package com.sumon.mynotes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
//Dao : DataAccessObject
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note : Note)

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * FROM notestable order by id ASC")  //ASC :Ascending
    fun getAllNotes() : LiveData<List<Note>>
}