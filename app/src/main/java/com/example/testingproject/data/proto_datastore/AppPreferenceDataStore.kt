package com.example.testingproject.data.proto_datastore

import android.util.Log
import androidx.datastore.core.DataStore
import com.example.testingproject.AppPreference
import com.example.testingproject.copy
import com.example.testingproject.data.model.AppTranslationData
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class AppPreferenceDataStore @Inject constructor(val dataStore: DataStore<AppPreference>) {

    val appTranslationData = dataStore.data.map {
        AppTranslationData(
            data = it.dataMessageMap
        )
    }


    suspend fun getDataByKey(key: String): String? {
        Log.e("THN", "getDataByKey: $key")
        return appTranslationData.map { current ->
            current.data?.get(key)
        }.first()


    }

    suspend fun setData(data: Map<String, String>) {
        Log.e("THN", "setData : $data")
        try {
            dataStore.updateData {
                it.copy {
                    dataMessage.putAll(data)
                }
            }
            Log.e("THN", " Data setup Success")
        } catch (ioException: IOException) {
            Log.e("THN", "Failed to update user preferences", ioException)
        }
    }

}