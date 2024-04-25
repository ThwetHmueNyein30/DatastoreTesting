package com.example.testingproject.di

import com.example.testingproject.data.EmployeeRepository
import com.example.testingproject.data.EmployeeRepositoryImpl
import com.example.testingproject.data.datastore.UserPreferenceImpl
import com.example.testingproject.data.datastore.UserPreference
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindRepository(impl: EmployeeRepositoryImpl): EmployeeRepository

}