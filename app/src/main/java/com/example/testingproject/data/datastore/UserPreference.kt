package com.example.testingproject.data.datastore

import kotlinx.coroutines.flow.Flow

interface UserPreference {
    fun userName(): Flow<String>
    suspend fun saveUserName(name: String)
}