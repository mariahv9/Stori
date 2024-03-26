package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HomeDAO {
    @Query("SELECT name || ' ' || surname FROM user WHERE id = :userId")
    fun getUserName(userId: String): Flow<String>

    @Query("SELECT balance FROM user WHERE id = :userId")
    fun getUserBalance(userId: String): Flow<Int>

    @Query("SELECT id FROM user LIMIT 1")
    suspend fun getUserId(): String?
}
