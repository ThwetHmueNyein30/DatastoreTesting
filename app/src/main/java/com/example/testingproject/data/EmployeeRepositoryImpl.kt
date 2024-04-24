package com.example.testingproject.data

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.protobuf.ByteString
import com.example.testingproject.EmployeeData
import com.example.testingproject.EmployeeList
import com.example.testingproject.copy
import com.example.testingproject.data.model.EmployeeInfoList
import com.example.testingproject.data.model.EmployeeItem
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import okhttp3.ResponseBody
import javax.inject.Inject

class EmployeeRepositoryImpl @Inject constructor( private val dataStore: DataStore<EmployeeList>) : EmployeeRepository {
    override suspend fun saveEmployeeInfo(employeeInfoList: EmployeeInfoList) {
        dataStore.updateData {
            it.copy {
                it.employeeList.clear()
                it.employeeList.addAll(employeeInfoList.toEmployeeList().employeeList)
            }
        }
    }

    override  fun getEmployeeInfo(): Flow<EmployeeInfoList> {
        return dataStore.data.map {
            EmployeeInfoList(it.employeeList)
        }
    }


    fun EmployeeInfoList.toEmployeeList(): EmployeeList {
        val employeeListBuilder = EmployeeList.newBuilder()
        employees.forEach { employeeItem ->
            employeeListBuilder.addAllEmployee(listOf(employeeItem.toEmployeeData()))
        }
        return employeeListBuilder.build()
    }

    fun EmployeeItem.toEmployeeData(): EmployeeData {
        val employeeDataBuilder = EmployeeData.newBuilder()
        employeeDataBuilder.setEmailAddress(emailAddress ?: "") // Handle null values appropriately
        employeeDataBuilder.setEmployeeCode(employeeCode ?: "")
        employeeDataBuilder.setFirstName(firstName ?: "")
        employeeDataBuilder.setJobTitleName(jobTitleName ?: "")
        employeeDataBuilder.setLastName(lastName ?: "")
        employeeDataBuilder.setPhoneNumber(phoneNumber ?: "")
        employeeDataBuilder.setPreferredFullName(preferredFullName ?: "")
        employeeDataBuilder.setRegion(region ?: "")
        employeeDataBuilder.setUserId(userId ?: "")
        return employeeDataBuilder.build()
    }


//    fun EmployeeList.toEmployeeInfoList(): EmployeeInfoList {
//        //val employeeListBuilder = EmployeeInfoList
//        val employeeItemBuilder = e
//        employeeList.forEach { employeeData ->
//            employeeListBuilder.addEmployee(employeeData)
//        }
//        return EmployeeInfoList(employees = persistentListOf( employeeListBuilder.build()))
//    }

    fun EmployeeData.toEmployeeItem(): EmployeeItem {
        return EmployeeItem(
            emailAddress = emailAddress,
            employeeCode = employeeCode,
            firstName = firstName,
            jobTitleName = jobTitleName,
            lastName = lastName,
            phoneNumber = phoneNumber,
            preferredFullName = preferredFullName,
            region = region,
            userId = userId
        )
    }

}