package com.example.roomdatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAllWords(): Flow<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addWord(word: Word)

    @Query("DELETE FROM WORD_TABLE")
    suspend fun deleteAll()
}