package com.example.roomwordssample.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.example.roomwordssample.repository.WordRepository
import com.example.roomwordssample.vo.Word

class WordViewModel constructor(application: Application)
    : AndroidViewModel(application){
    //constructor(application: Application) : super(application)

    var mRepository : WordRepository
    var mAllWords : LiveData<List<Word>>
    init {
        mRepository = WordRepository.getInstance(application)
        mAllWords = mRepository.getAllWords()
    }

    fun getAllWords() = mAllWords

    fun insert (word : Word) = mRepository.insert(word)
}