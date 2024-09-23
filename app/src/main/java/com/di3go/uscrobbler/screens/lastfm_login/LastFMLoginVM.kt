package com.di3go.uscrobbler.screens.lastfm_login

import androidx.lifecycle.ViewModel
import com.di3go.uscrobbler.LastFMRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LastFMLoginVM @Inject constructor(
    private val repository: LastFMRepository
) : ViewModel() {
    fun saveToken(token: String) {
        repository.saveToken(token)
    }
}