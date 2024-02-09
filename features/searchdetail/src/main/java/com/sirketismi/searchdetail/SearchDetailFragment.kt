package com.sirketismi.searchdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.sirketismi.common.base.BaseFragment
import com.sirketismi.searchdetail.databinding.FragmentSearchDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchDetailFragment: BaseFragment<FragmentSearchDetailBinding , SearchDetailViewModel>(FragmentSearchDetailBinding::inflate) {
    val viewModel : SearchDetailViewModel by viewModels()
    val args : SearchDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val itemId = it.getString("itemId")
        }
    }

    override fun aViewModel(): SearchDetailViewModel {
        return viewModel
    }
}