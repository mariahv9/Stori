package com.example.stori.di

import com.example.domain.di.DomainModule
import com.example.domain.repository.LoginRepository
import com.example.domain.usecase.GetLoginUseCase
import com.example.domain.usecase.GetLoginUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(
    includes = [
        DomainModule::class
    ]
)
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun providerLoginUseCase(repository: LoginRepository): GetLoginUseCase {
        return GetLoginUseCaseImpl(repository)
    }
}
