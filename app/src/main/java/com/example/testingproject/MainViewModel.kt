package com.example.testingproject

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testingproject.data.EmployeeRepository
import com.example.testingproject.data.model.EmployeeInfoList
import com.example.testingproject.data.model.UserData
import com.example.testingproject.data.proto_datastore.EmployeeDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: EmployeeRepository
) : ViewModel() {

    fun setData(employeeInfoList: EmployeeInfoList){
        Log.d("THN", "setData: ${employeeInfoList.employees?.size}")
//        viewModelScope.launch {
//            repository.saveEmployeeInfo(employeeInfoList)
//        }
    }

    fun getData() {
        viewModelScope.launch {
            repository.getEmployeeInfo()
        }
    }




}
