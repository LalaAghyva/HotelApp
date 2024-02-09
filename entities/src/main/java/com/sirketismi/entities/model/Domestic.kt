package com.sirketismi.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Domestic (
	val image : String,
	val index : Int
) : Parcelable