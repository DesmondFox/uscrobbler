package com.di3go.uscrobbler.screens.connect

import com.di3go.uscrobbler.data.providers.LastFMProvider
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ConnectVM @Inject constructor(
    val repository: LastFMProvider
) : ViewModel() {
}