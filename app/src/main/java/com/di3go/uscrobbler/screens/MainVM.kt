package com.di3go.uscrobbler.screens

import androidx.lifecycle.ViewModel
import com.di3go.uscrobbler.data.providers.LastFMProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(
    private val repository: LastFMProvider
) : ViewModel() {
    fun hasToken(): Boolean {
        return repository.getToken() != null
    }
}