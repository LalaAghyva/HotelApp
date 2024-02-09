package com.sirketismi.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize



@Parcelize
data class Json4Kotlin_Base (
	val responseCode : Int,
	val errors : String,
	val message : String,
	val result : Result,
	val campaignBanners : Campaign_banners
) : Parcelable