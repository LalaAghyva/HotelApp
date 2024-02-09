package com.sirketismi.domain.mapper

import com.sirketismi.entities.model.Result
import com.sirketismi.entities.model.Json4Kotlin_Base
import com.sirketismi.entities.uimodel.HotelListUIModel
import com.sirketismi.entities.uimodel.HotelSearchUIState
import com.sirketismi.entities.uimodel.SearchHeaderUiModel
import javax.inject.Inject

class Json4Kotlin_BaseToUIStateMapper @Inject constructor():
    BaseMapper<Result, HotelSearchUIState> {

    override fun map(input: Result): HotelSearchUIState {
        return HotelSearchUIState(
            header = input.getSearchHeader(),
            hotels =  input.getHotels()
        )
    }

    private fun Result.getSearchHeader() : SearchHeaderUiModel {
        return SearchHeaderUiModel(
            origin = offers?: "",
            destination = "")
    }

    private fun Result.getHotels() : List<HotelListUIModel> {
        return offers?.hotels?.map {
            HotelListUIModel(
                it.requestId ?: "",
                hotelPhoto = it.rooms?.firstOrNull()?.images ?: "",
                hotelName = it.details.name ?: "",
                price = 0.0)
        } ?: listOf()
    }


}