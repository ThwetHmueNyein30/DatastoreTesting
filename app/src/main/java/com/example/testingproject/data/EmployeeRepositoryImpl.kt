package com.example.testingproject.data

import android.util.Log
import com.example.testingproject.data.model.AppTranslationData
import com.example.testingproject.data.proto_datastore.AppPreferenceDataStore
import javax.inject.Inject

class EmployeeRepositoryImpl @Inject constructor(private val dataStore: AppPreferenceDataStore) :
    EmployeeRepository {
    //        override val employeeData: Flow<EmployeeItem>
//        get() = dataStore.employeeData
//
//    override suspend fun saveEmployeeInfo(employeeItem: EmployeeItem) {
//       dataStore.saveData(employeeItem)
//    }
//    override val translationData: Flow<AppTranslationData>
//        get() = dataStore.appTranslationData

    override suspend fun getDataByKey(key: String): String? {
        Log.e("THN", "getDataByKey: ${dataStore.getDataByKey(key)}... key..$key", )
       return dataStore.getDataByKey(key)
    }

    override suspend fun saveData(data: AppTranslationData) {
        Log.e("THN", "saveData in data store: $data", )
        data.data?.let { dataStore.setData(it) }
    }

}
