package com.example.effectivemobiletester.repository

import com.example.effectivemobiletester.data.local.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val userDao: UserDao
) {

    suspend fun getCurrentUser() = withContext(Dispatchers.IO) {

    }
}