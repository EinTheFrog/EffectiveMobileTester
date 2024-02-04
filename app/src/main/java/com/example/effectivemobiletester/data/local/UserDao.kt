package com.example.effectivemobiletester.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.effectivemobiletester.model.local.UserLocal

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun loadAll(first: String, last: String): UserLocal

    @Insert
    suspend fun insert(user: UserLocal)

    @Query("DELETE FROM user")
    suspend fun deleteAll()
}