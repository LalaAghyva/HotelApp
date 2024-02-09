package com.sirketismi.entities.uimodel

data class HotelSearchUIState(
    val header: SearchHeaderUiModel,
    var hotels: List<HotelListUIModel>)

data class SearchHeaderUiModel(
    val origin: Any,
    val destination: String)

data class HotelListUIModel(
    var requestId: String,
    var hotelPhoto: Any,
    var hotelName: String,
    val price: Double )