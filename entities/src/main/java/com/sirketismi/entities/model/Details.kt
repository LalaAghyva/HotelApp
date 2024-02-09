package com.sirketismi.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Details (
	val id : String,
	val slug : String,
	val address : Address,
	val coordinate : Coordinate,
	val description : String,
	val hotelInfoDescription : String,
	val facilitiesGroup : List<String>,
	val suitabilities : List<String>,
	val hotelDescriptions : List<String>,
	val extra : Extra,
	val name : String,
	val images : List<String>,
	val starRating : Int,
	val reviewScore : Int,
	val reviews : String,
	val reviewInfo : String,
	val reviewScoreLocalized : String,
	val generalReviewScoreNote : String,
	val checkInTime : String,
	val checkOutTime : String,
	val domestic : Boolean,
	val reviewsTotalCount : String,
	val cityCenterPointDistance : Double,
	val cityCenterPointDistanceName : String,
	val hotelConcept : List<String>,
	val nearByHotels : String,
	val covidInfo : String,
	val imageTypes : List<String>,
	val hotelAutocompleteIcon : String,
	val locationDistance : String,
	val policies : Policies
) : Parcelable