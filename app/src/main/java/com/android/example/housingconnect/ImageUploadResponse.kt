package com.android.example.housingconnect

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImageUploadResponse(
        val message: String,
        val type: String
) : Parcelable

// TODO: PHASE 2.2 - Define ImageUploadResponse Data Class
//  Stores two variables of type String called message and type
