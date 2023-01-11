package com.sinyee.babyb.oothththt

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class GeoDev(
    @SerializedName("geo")
    val geo: String,
    @SerializedName("view")
    val view: String,
    @SerializedName("isAppsLaunched")
    val isAppsLaunched: String,
)
