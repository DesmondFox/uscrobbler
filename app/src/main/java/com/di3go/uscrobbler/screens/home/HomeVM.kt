package com.di3go.uscrobbler.screens.home

import androidx.lifecycle.ViewModel
import com.di3go.uscrobbler.data.providers.LastFMProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
    private val lastFMProvider: LastFMProvider
) : ViewModel() {
    fun getToken(): String? {
        return lastFMProvider.getToken()
    }
}