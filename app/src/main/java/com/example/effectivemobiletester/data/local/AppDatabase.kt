package com.example.effectivemobiletester.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.effectivemobiletester.model.local.UserLocal

@Database(entities = [UserLocal::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}