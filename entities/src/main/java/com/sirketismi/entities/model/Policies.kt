package com.sirketismi.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Policies (
	val checkIn : Checkin,
	val checkout : String,
	val instructions : String,
	val specialInstructions : String,
	val checkInMinAge : String,
	val fees : Fees,
	val knowBeforeYouGo : String
) : Parcelable