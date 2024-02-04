package com.example.effectivemobiletester.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserDao::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}