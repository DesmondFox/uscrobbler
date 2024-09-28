package com.di3go.uscrobbler.screens.lastfm_login

import androidx.lifecycle.ViewModel
import com.di3go.uscrobbler.LastFMRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LastFMLoginVM @Inject constructor(
    private val repository: LastFMRepository
) : ViewModel() {
    private val _isTokenSaved = MutableStateFlow(false)
    val isTokenSaved: StateFlow<Boolean> = _isTokenSaved

    suspend fun saveToken(token: String) {
        repository.saveToken(token)
        delay(4000)
        _isTokenSaved.value = true
    }
}