package com.example.roomdatabase

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class WordRepository(private val wordDao: WordDao) {
    val allWords: Flow<List<Word>> = wordDao.getAllWords()

    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.addWord(word)
    }
}