package com.example.testingproject.screen

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.testingproject.MainViewModel
import com.example.testingproject.data.model.EmployeeInfoList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Composable
fun FirstScreen(navController: NavController, viewModel: MainViewModel = hiltViewModel()) {
    var employeeInfoList by remember { mutableStateOf(EmployeeInfoList()) }
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        employeeInfoList = getEmployeesFromAssets(context, "employees.json")
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "This is the Main Screen.....${employeeInfoList.employees?.size}")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("second_screen")
            viewModel.setData(employeeInfoList)
        }) {
            Text(text = "Go to Second Screen")
        }
    }
}


fun getEmployeesFromAssets(context: Context, fileName: String): EmployeeInfoList {
    val jsonString: String
    try {
        val inputStream = context.assets.open(fileName)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        jsonString = String(buffer)
    } catch (e: Exception) {
        // Handle error
        return EmployeeInfoList()
    }

    val gson = Gson()
    val employeeList: EmployeeInfoList =
        gson.fromJson(jsonString, object : TypeToken<EmployeeInfoList>() {}.type)
    return employeeList
}

