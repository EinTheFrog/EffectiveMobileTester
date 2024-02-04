package com.example.effectivemobiletester.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = UserLocal.TABLE_NAME)
data class UserLocal(
    @PrimaryKey val id: Long,
    @ColumnInfo("login") val login: String,
    @ColumnInfo("password") val password: String,
) {
    companion object {
        const val TABLE_NAME = "user"
    }
}