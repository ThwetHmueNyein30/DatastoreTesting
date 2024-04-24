package com.example.testingproject.data

import com.example.testingproject.data.model.EmployeeInfoList
import com.example.testingproject.data.model.EmployeeItem
import kotlinx.coroutines.flow.Flow

interface EmployeeRepository {

    suspend fun saveEmployeeInfo(employeeInfoList: EmployeeInfoList)

     fun getEmployeeInfo():Flow<EmployeeInfoList>
}