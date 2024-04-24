package com.example.testingproject.data.proto_datastore

import androidx.datastore.core.DataStore
import com.example.testingproject.EmployeeList
import com.example.testingproject.data.model.EmployeeInfoList
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class EmployeeDataStore @Inject constructor(
    private val employee: DataStore<EmployeeList>
) {

//    val employeeData = employee.data.map {
//        EmployeeInfoList(
//            employees = it
//        )
//    }
//
//

}

