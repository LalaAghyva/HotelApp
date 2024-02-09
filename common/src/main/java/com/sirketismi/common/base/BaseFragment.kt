package com.sirketismi.common.base

import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.sirketismi.common.flowstate.Status
import com.sirketismi.common.util.LoadingDialog
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T
open abstract class BaseFragment<B : ViewBinding, V : BaseViewModel>(private val inflate: Inflate<B>): Fragment() {
    private lateinit var loadingDialog: LoadingDialog
    private var _binding : ViewBinding? = null
    protected val binding : B get() = _binding as B

    abstract fun aViewModel() : V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.let {
            loadingDialog = LoadingDialog(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handelState()
    }

    fun handelState() {
        lifecycleScope.launch {
            aViewModel().state.collectLatest {state->
                state?.let {
                    when(it.status) {
                        Status.SUCCESS -> showLoadingProgress(false)
                        Status.ERROR -> showLoadingProgress(false)
                        Status.LOADING -> showLoadingProgress(false)
                    }
                }
            }
        }
    }
    private fun showLoadingProgress(isLoad : Boolean) {
        if(::loadingDialog.isInitialized) {
            loadingDialog.apply {
                if(isLoad) {
                    if(!isShowing && isAdded)
                        show()
                } else {
                    if(isShowing) dismiss()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}