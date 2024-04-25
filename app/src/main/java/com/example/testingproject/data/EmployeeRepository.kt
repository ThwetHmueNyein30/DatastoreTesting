package com.example.testingproject.data

import com.example.testingproject.data.model.AppTranslationData
import com.example.testingproject.data.model.EmployeeItem
import kotlinx.coroutines.flow.Flow

interface EmployeeRepository {

    //val translationData: Flow<AppTranslationData>

    suspend fun getDataByKey(key : String):String?

    suspend fun saveData(data: AppTranslationData)

}