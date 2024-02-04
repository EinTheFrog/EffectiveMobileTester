package com.example.effectivemobiletester.di

import android.content.Context
import androidx.room.Room
import com.example.effectivemobiletester.data.local.AppDatabase
import com.example.effectivemobiletester.data.local.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomProvider {

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }

    companion object {
        const val DATABASE_NAME = "app_database"
    }
}