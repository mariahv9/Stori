package com.example.data.di

import android.content.Context
import com.example.data.datasource.HomeDataSource
import com.example.data.datasource.LoginDatasource
import com.example.data.datasource.RegisterDataSource
import com.example.data.db.RoomDB
import com.example.data.db.dao.HomeDAO
import com.example.data.db.dao.LoginDAO
import com.example.data.db.dao.RegisterDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DBModule {
    @Singleton
    @Provides
    fun getDatabase(@ApplicationContext context: Context): RoomDB {
        return RoomDB.getDatabase(context)
    }

    @Singleton
    @Provides
    fun loginDao(roomDB: RoomDB): LoginDAO {
        return roomDB.loginDao()
    }

    @Singleton
    @Provides
    fun registerDao(roomDB: RoomDB): RegisterDAO {
        return roomDB.registerDao()
    }

    @Singleton
    @Provides
    fun homeDao(roomDB: RoomDB): HomeDAO {
        return roomDB.homeDao()
    }

    @Singleton
    @Provides
    fun providerLoginDataSource(loginDAO: LoginDAO): LoginDatasource =
        LoginDatasource(loginDAO)

    @Singleton
    @Provides
    fun providerRegisterDataSource(registerDAO: RegisterDAO): RegisterDataSource =
        RegisterDataSource(registerDAO)

    @Singleton
    @Provides
    fun providerHomeDataSource(homeDAO: HomeDAO): HomeDataSource =
        HomeDataSource(homeDAO)
}
