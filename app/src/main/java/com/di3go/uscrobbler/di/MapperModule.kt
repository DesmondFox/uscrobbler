package com.di3go.uscrobbler.di

import com.di3go.uscrobbler.data.apis.LastFMUserApi
import com.di3go.uscrobbler.data.mappers.LastFMUserMapper
import com.di3go.uscrobbler.data.mappers.NetworkMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MapperModule {
    @Provides
    @Singleton
    fun provideNetworkMapper(lastFMUserApi: LastFMUserApi): LastFMUserMapper {
        return NetworkMapperImpl(lastFMUserApi)
    }
}