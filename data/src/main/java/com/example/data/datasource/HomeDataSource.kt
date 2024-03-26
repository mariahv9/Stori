package com.example.data.datasource

import com.example.common.Resource
import com.example.data.db.dao.HomeDAO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeDataSource @Inject constructor(private val homeDAO: HomeDAO) {
    suspend fun getUserName(userId: String): Flow<String> {
        return homeDAO.getUserName(userId)
    }

    suspend fun getUserBalance(userId: String): Resource<Int> {
        return try {
            val userName = homeDAO.getUserBalance(userId).single()
            Resource.Success(userName)
        } catch (e: Exception) {
            Resource.Failure(e)
        }
    }

    suspend fun getUserId(): Resource<String?> {
        return try {
            val userId = homeDAO.getUserId()
            if (userId != null) {
                Resource.Success(userId)
            } else {
                Resource.Failure(Exception("No se encontró el ID del usuario"))
            }
        } catch (e: Exception) {
            Resource.Failure(e)
        }
    }
}
