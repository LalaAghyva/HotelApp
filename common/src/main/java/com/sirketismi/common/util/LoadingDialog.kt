package com.sirketismi.common.util

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import com.sirketismi.common.databinding.DialogLoadingBinding

class LoadingDialog(context : Activity) : Dialog(context) {
    private val binding : DialogLoadingBinding = DialogLoadingBinding.inflate(LayoutInflater.from(context))

    init {
        if(context is Activity)
            setOwnerActivity(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}