package com.example.testingproject.di

import com.example.testingproject.data.UserPreferenceImpl
import com.example.testingproject.data.UserPreference
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class UserPreferenceModule {

    @Binds
    abstract fun bindUserPreferences(impl: UserPreferenceImpl): UserPreference
}