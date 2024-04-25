package com.example.testingproject

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testingproject.data.EmployeeRepository
import com.example.testingproject.data.model.AppTranslationData
import com.example.testingproject.data.model.EmployeeItem
import com.example.testingproject.data.model.EmployeeList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: EmployeeRepository
) : ViewModel() {

    private val _dataSaveState = MutableStateFlow<DataSaveState>(DataSaveState.Loading)
    val dataSaveState: StateFlow<DataSaveState> = _dataSaveState.asStateFlow()

    var translationData: String = ""

    fun setData(data: AppTranslationData){
        viewModelScope.launch {
            repository.saveData(data)
        }
    }

    fun getData(key:String) {
        viewModelScope.launch {
            translationData = repository.getDataByKey(key).toString()
        }
    }

    sealed class DataSaveState {
        object Loading : DataSaveState()
        object Error : DataSaveState()
        object Success : DataSaveState()
    }

}
