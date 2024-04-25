package com.example.testingproject.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class EmployeeList(
    @SerializedName("Employees") val employees: ArrayList<EmployeeItem> = arrayListOf()

)

@Serializable
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

