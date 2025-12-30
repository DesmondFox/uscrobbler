package com.di3go.uscrobbler.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TrackInfo(
    val artist: String?,
    val title: String?,
    val album: String?,
    val durationMs: Int?,
) : Parcelable