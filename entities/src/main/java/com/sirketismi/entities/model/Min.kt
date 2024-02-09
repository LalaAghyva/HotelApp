package com.sirketismi.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Min (
	val name : String,
	val code : String,
	val value : String,
	val type : String,
	val position : Int,
	val count : String
) : Parcelable