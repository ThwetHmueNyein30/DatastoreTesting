package com.example.testingproject.di

import com.example.testingproject.data.EmployeeRepository
import com.example.testingproject.data.EmployeeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
//    @Provides
//    @Singleton
//    fun provideEmployeeRepository(): EmployeeRepository {
//        return EmployeeRepositoryImpl
//    }
//
}