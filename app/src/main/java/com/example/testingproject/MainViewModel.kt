package com.example.testingproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testingproject.data.UserPreference
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val userPreference: UserPreference
) : ViewModel() {

    val userName: StateFlow<String> = userPreference.userName().filter {
        it.isNotEmpty()
    }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            "No saved data"
        )
    fun saveUserName(name: String) {
        viewModelScope.launch {
            userPreference.saveUserName(name)
        }
    }
}