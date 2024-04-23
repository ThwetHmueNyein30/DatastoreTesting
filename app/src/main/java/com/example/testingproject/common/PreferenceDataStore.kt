package com.example.testingproject.common

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

fun <T> DataStore<Preferences>.getData(
    key: Preferences.Key<T>, defaultValue: T
): Flow<T> {
    return this.data.catch { emit(emptyPreferences()) }.map { preferences ->
        preferences[key] ?: defaultValue
    }
}

suspend fun <T> DataStore<Preferences>.setData(
    key: Preferences.Key<T>, value: T
) {
    edit { preference ->
        preference[key] = value
    }
}