package com.example.roomwordssample.db

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.roomwordssample.vo.Word

@Database(
        entities = [Word::class],
        version = 1
)
abstract class WordRoomDatabase : RoomDatabase() {
    abstract fun wordsDao() : WordsDao

    companion object {

        const val DATABASE_NAME = "words-db"

        // For Singleton instantiation
        @Volatile private var instance: WordRoomDatabase? = null

        fun getInstance(context: Context): WordRoomDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): WordRoomDatabase {
            return Room.databaseBuilder(context, WordRoomDatabase::class.java, DATABASE_NAME)
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            /*val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>().build()
                            WorkManager.getInstance().enqueue(request)*/
                        }
                    })
                    .fallbackToDestructiveMigration()
                    .build()
        }
    }
}