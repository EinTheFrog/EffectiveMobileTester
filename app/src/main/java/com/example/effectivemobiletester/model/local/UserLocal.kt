package com.example.effectivemobiletester.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = UserLocal.TABLE_NAME)
data class UserLocal(
    @PrimaryKey val id: Long,
    @ColumnInfo("first_name") val firstName: String,
    @ColumnInfo("last_name") val lastName: String,
    @ColumnInfo("phone") val phone: String,
) {
    companion object {
        const val TABLE_NAME = "user"
    }
}