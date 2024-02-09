package com.sirketismi.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize



@Parcelize
data class Fees (
	val mandatory : String,
	val optional : String
) : Parcelable