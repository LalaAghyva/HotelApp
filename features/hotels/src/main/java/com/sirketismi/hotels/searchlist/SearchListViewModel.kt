package com.sirketismi.hotels.searchlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sirketismi.common.base.BaseViewModel
import com.sirketismi.common.flowstate.Resource
import com.sirketismi.common.flowstate.State
import com.sirketismi.domain.mapper.Json4Kotlin_BaseToUIStateMapper
import com.sirketismi.domain.usecase.SearchListUseCase
import com.sirketismi.entities.model.Json4Kotlin_Base
import com.sirketismi.entities.uimodel.HotelSearchUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchListViewModel @Inject constructor(
    val searchListUseCase: SearchListUseCase,
    private val mapper: Json4Kotlin_BaseToUIStateMapper) : BaseViewModel() {

    val data = MutableLiveData<HotelSearchUIState?>()

    suspend fun getHotels() {
        searchListUseCase.getList().collectLatest {
            when(it) {
                is Resource.Error -> state.emit(State.error(it.message))
                is Resource.Loading -> state.emit(State.loading())
                is Resource.Success -> {
                    state.emit(State.success())
                    it.data?.let {
                        data.postValue(it)
                    }

                }
            }
        }
    }
}
