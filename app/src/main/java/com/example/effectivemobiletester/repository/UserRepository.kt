package com.example.effectivemobiletester.repository

import com.example.effectivemobiletester.data.local.UserDao
import com.example.effectivemobiletester.model.UserMapper
import com.example.effectivemobiletester.model.domain.UserDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val userDao: UserDao,
    private val userMapper: UserMapper,
) {

    suspend fun getCurrentUser() = withContext(Dispatchers.IO) {
        try {
            val usersLocal = userDao.loadAll()
            val usersDomain = usersLocal.map { userMapper.localToDomain(it) }
            if (usersDomain.size == 0) {
                return@withContext Result.success(null)
            } else if (usersDomain.size > 1) {
                clearUsers()
                return@withContext Result.success(null)
            } else {
                return@withContext Result.success(usersDomain[0])
            }
        } catch (e: Exception) {
            return@withContext Result.failure(e)
        }
    }

    suspend fun saveCurrentUser(userDomain: UserDomain) = withContext(Dispatchers.IO) {
        try {
            val userLocal = userMapper.domainToLocal(userDomain)
            userDao.deleteAll()
            userDao.insert(userLocal)
            return@withContext Result.success(Unit)
        } catch (e: Exception) {
            return@withContext Result.failure(e)
        }
    }

    suspend fun clearUsers() = withContext(Dispatchers.IO) {
        try {
            userDao.deleteAll()
            return@withContext Result.success(Unit)
        } catch (e: Exception) {
            return@withContext Result.failure(e)
        }
    }
}