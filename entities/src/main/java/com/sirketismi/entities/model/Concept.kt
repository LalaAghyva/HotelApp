package com.sirketismi.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Concept (
	val code : Int,
	val description : String,
	val parentCode : String,
	val conceptIconColorCode : String,
	val conceptIcon : String
) : Parcelable