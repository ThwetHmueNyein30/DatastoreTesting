package com.example.testingproject.data.model

import com.example.testingproject.EmployeeList
import com.google.gson.annotations.SerializedName
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class EmployeeInfoList(
    @SerializedName("Employees") val employees: PersistentList<EmployeeItem> = persistentListOf()

)

data class EmployeeItem(
    val emailAddress: String? = null,
    val employeeCode: String? = null,
    val firstName: String? = null,
    val jobTitleName: String? = null,
    val lastName: String? = null,
    val phoneNumber: String? = null,
    val preferredFullName: String? = null,
    val region: String? = null,
    val userId: String? = null
)

