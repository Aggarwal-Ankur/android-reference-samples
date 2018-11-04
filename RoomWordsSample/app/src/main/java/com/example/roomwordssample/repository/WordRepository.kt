package com.example.roomwordssample.repository

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.example.roomwordssample.db.WordRoomDatabase
import com.example.roomwordssample.db.WordsDao
import com.example.roomwordssample.vo.Word


class WordRepository private constructor(
        val mWordDao : WordsDao,
        val mAllWords : LiveData<List<Word>>
){

    fun getAllWords() = mAllWords

    fun insert(word: Word){
        insertAsyncTask(mWordDao).execute(word);
    }

    companion object {
        // For Singleton instantiation
        @Volatile private var instance: WordRepository? = null

        fun getInstance(application : Application) =
                instance ?: synchronized(this) {
                    val db = WordRoomDatabase.getInstance(application)
                    val wordDao : WordsDao = db.wordsDao()
                    val allWords = wordDao.getAllWords()
                    instance ?: WordRepository(wordDao, allWords).also { instance = it }
                }
    }

    private class insertAsyncTask constructor(val mAsyncTaskDao : WordsDao) : AsyncTask<Word, Void, Void>() {
        override fun doInBackground(vararg params: Word): Void? {
            mAsyncTaskDao.inserWord(params[0])
            return null
        }
    }
}