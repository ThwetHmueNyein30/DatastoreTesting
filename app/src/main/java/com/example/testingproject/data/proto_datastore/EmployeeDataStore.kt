package com.example.testingproject.data.proto_datastore

import android.util.Log
import androidx.datastore.core.DataStore
import com.example.testingproject.EmployeeData
import com.example.testingproject.copy
import com.example.testingproject.data.model.EmployeeItem
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class EmployeeDataStore @Inject constructor(
    private val dataStore: DataStore<EmployeeData>
) {

    val employeeData = dataStore.data.map {
        EmployeeItem(
            emailAddress = it.emailAddress,
            employeeCode = it.employeeCode,
            firstName = it.firstName,
            jobTitleName = it.jobTitleName,
            lastName = it.lastName,
            phoneNumber = it.phoneNumber,
            preferredFullName = it.preferredFullName,
            region = it.region,
            userId = it.userId
        )
    }

    suspend fun saveData(employeeData: EmployeeItem) {
        try {
            dataStore.updateData {
                it.copy {
                    this.emailAddress = employeeData.emailAddress.toString()
                    this.employeeCode = employeeData.employeeCode.toString()
                    this.firstName = employeeData.firstName.toString()
                    this.jobTitleName = employeeData.jobTitleName.toString()
                    this.lastName = employeeData.lastName.toString()
                    this.phoneNumber = employeeData.phoneNumber.toString()
                    this.preferredFullName = employeeData.preferredFullName.toString()
                    this.region = employeeData.region.toString()
                    this.userId = employeeData.userId.toString()

                }
            }
            Log.e("THN", "Success")


        } catch (ioException: IOException) {
            Log.e("THN", "Failed to update user preferences", ioException)
        }
    }


}

