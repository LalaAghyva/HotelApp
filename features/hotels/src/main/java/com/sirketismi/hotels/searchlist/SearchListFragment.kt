package com.sirketismi.hotels.searchlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sirketismi.common.base.BaseFragment
import com.sirketismi.common.flowstate.Status
import com.sirketismi.common.util.toDetail
import com.sirketismi.hotels.databinding.FreagmentSearchListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SearchListFragment : BaseFragment<FreagmentSearchListBinding, SearchListViewModel>(FreagmentSearchListBinding::inflate) {
    val viewModel : SearchListViewModel by viewModels()

    private lateinit var adapter: SearchListAdapter

    override fun aViewModel(): SearchListViewModel {
        return viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecylerAdapter()

            lifecycleScope.launch {
                viewModel.getHotels()
            }

        viewModel.data.observe(viewLifecycleOwner) {
            adapter.setData(it?.hotels ?: listOf())
        }
    }

    private fun initRecylerAdapter() {
        adapter = SearchListAdapter {
            findNavController().toDetail(it.requestId)
        }
        binding.recylerview.layoutManager = LinearLayoutManager(context)
        binding.recylerview.adapter = adapter
    }

}