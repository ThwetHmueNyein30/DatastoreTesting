package com.example.testingproject.screen

import android.content.Context
import android.util.Log
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
import com.example.testingproject.data.model.AppTranslationData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


@Composable
fun FirstScreen(navController: NavController, viewModel: MainViewModel = hiltViewModel()) {
    var data by remember { mutableStateOf(AppTranslationData()) }
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        data = getEmployeesFromAssets(context, "app_preference.json")
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "This is the Main Screen.")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("second_screen")
            viewModel.setData(data)
        }) {
            Text(text = "Save Data")
        }
    }
}



fun getEmployeesFromAssets(context: Context, fileName: String): AppTranslationData {
    val jsonString: String
    try {
        val inputStream = context.assets.open(fileName)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        jsonString = String(buffer)
        Log.e("THN", "getEmployeesFromAssets: success ", )
    } catch (e: Exception) {
        Log.e("THN", "getEmployeesFromAssets: error ", )

        // Handle error
        return AppTranslationData()
    }

    val gson = Gson()
    val data: AppTranslationData =
        gson.fromJson(jsonString, object : TypeToken<AppTranslationData>() {}.type)
    return data
}

