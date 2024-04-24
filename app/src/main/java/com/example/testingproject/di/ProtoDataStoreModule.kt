package com.example.testingproject.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.example.testingproject.EmployeeList
import com.example.testingproject.data.proto_datastore.EmployeeInfoSerializer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
object ProtoDataStoreModule {

    @Provides
    @Singleton
    internal fun providesUserPreferencesDataStore(
        @ApplicationContext context: Context,
        employeeInfoSerializer: EmployeeInfoSerializer,
    ): DataStore<EmployeeList> =
        DataStoreFactory.create(
            serializer = employeeInfoSerializer,
        ) {
            context.dataStoreFile("employee_list.pb")
        }
}




