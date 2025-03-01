package com.di3go.uscrobbler.data.mappers

import com.di3go.uscrobbler.data.apis.LastFMUserApi
import javax.inject.Inject

interface LastFMUserMapper {
}

class NetworkMapperImpl @Inject constructor(
    private val lastFMUserApi: LastFMUserApi
) : LastFMUserMapper {

}