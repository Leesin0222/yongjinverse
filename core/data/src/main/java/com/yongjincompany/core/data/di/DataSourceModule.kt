package com.yongjincompany.core.data.di

import com.yongjincompany.core.data.remote.datasource.RemoteUserDataSourceImpl
import com.yongjincompany.core.data.remote.datasource.RemoteUsersDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun provideRemoteUserDataSource(
        remoteUserDataSourceImpl: RemoteUserDataSourceImpl
    ): RemoteUsersDataSource
}