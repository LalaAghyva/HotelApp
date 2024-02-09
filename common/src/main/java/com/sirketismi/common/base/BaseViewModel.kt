package com.sirketismi.common.base

import androidx.lifecycle.ViewModel
import com.sirketismi.common.flowstate.State
import kotlinx.coroutines.flow.MutableStateFlow

open class BaseViewModel: ViewModel() {
    val state: MutableStateFlow<State?> = MutableStateFlow(null)

}