package com.example.roomwordssample.vo

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import org.jetbrains.annotations.NotNull

@Entity(tableName ="word_table", primaryKeys = ["word"])
data class Word (
        @NotNull
        @ColumnInfo(name = "word")
        val word : String
)