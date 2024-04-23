package com.example.testingproject.data

import kotlinx.coroutines.flow.Flow

interface UserPreference {
    fun userName(): Flow<String>
    suspend fun saveUserName(name: String)
}