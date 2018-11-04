package com.example.roomwordssample.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.roomwordssample.vo.Word

@Dao
abstract class WordsDao {
    @Insert
    abstract fun inserWord(word: Word)

    @Query("DELETE FROM word_table")
    abstract fun deleteAllWords()

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    abstract fun getAllWords() : LiveData<List<Word>>
}