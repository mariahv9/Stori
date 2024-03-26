package com.example.domain.di

import com.example.data.datasource.HomeDataSource
import com.example.data.datasource.LoginDatasource
import com.example.data.datasource.RegisterDataSource
import com.example.data.db.RoomDB
import com.example.data.db.dao.LoginDAO
import com.example.data.db.dao.RegisterDAO
import com.example.domain.repository.HomeRepository
import com.example.domain.repository.HomeRepositoryImpl
import com.example.domain.repository.LoginRepository
import com.example.domain.repository.LoginRepositoryImpl
import com.example.domain.repository.RegisterRepository
import com.example.domain.repository.RegisterRepositoryImpl
import com.example.domain.usecase.GetHomeUseCase
import com.example.domain.usecase.GetHomeUseCaseImpl
import com.example.domain.usecase.GetRegisterUseCase
import com.example.domain.usecase.GetRegisterUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Provides
    fun providerLoginRepository(loginDataSource: LoginDatasource): LoginRepository {
        return LoginRepositoryImpl(loginDataSource)
    }

    @Provides
    fun providesRegisterUseCase(registerRepository: RegisterRepository): GetRegisterUseCase =
        GetRegisterUseCaseImpl(registerRepository)

    @Provides
    fun providesRegisterRepository(registerDataSource: RegisterDataSource): RegisterRepository =
        RegisterRepositoryImpl(registerDataSource)

    @Provides
    fun providesHomeUseCase(homeRepository: HomeRepository): GetHomeUseCase =
        GetHomeUseCaseImpl(homeRepository)

    @Provides
    fun providesHomeRepository(homeDataSource: HomeDataSource): HomeRepository =
        HomeRepositoryImpl(homeDataSource)
}
