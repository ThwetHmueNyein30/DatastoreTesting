package com.example.testingproject.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.testingproject.common.getData
import com.example.testingproject.common.setData
import com.example.testingproject.data.datastore.KEYS.KEY_USER_NAME
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserPreferenceImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : UserPreference {

    override fun userName(): Flow<String> {
        return dataStore.getData(KEY_USER_NAME, "")
    }

    override suspend fun saveUserName(name: String) {
        dataStore.setData(KEY_USER_NAME, name)
    }
}

object KEYS {
    val KEY_USER_NAME = stringPreferencesKey("user_name")
}