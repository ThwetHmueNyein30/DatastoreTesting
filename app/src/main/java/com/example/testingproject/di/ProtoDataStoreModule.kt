package com.example.testingproject.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.example.testingproject.AppPreference
import com.example.testingproject.EmployeeData
import com.example.testingproject.data.proto_datastore.AppPreferenceSerializer
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
        appPreferenceSerializer: AppPreferenceSerializer,
    ): DataStore<AppPreference> =
        DataStoreFactory.create(
            serializer = appPreferenceSerializer,
        ) {
            context.dataStoreFile("app_preference.pb")
        }
}




