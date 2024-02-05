package com.example.effectivemobiletester.di

import com.example.effectivemobiletester.model.UserMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class MapperProvider {

    @Provides
    fun providerUserMapper(): UserMapper {
        return UserMapper()
    }
}