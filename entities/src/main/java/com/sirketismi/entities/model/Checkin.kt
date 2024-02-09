package com.sirketismi.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Checkin (

	val beginTime : String,
	val endTime : String
) : Parcelable