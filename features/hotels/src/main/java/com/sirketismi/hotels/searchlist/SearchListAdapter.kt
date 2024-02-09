package com.sirketismi.hotels.searchlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sirketismi.entities.uimodel.HotelListUIModel
import com.sirketismi.hotels.databinding.ListItemHotelBinding

class SearchListAdapter(val onClickItem : (HotelListUIModel)-> Unit): RecyclerView.Adapter<SearchListViewHolder>() {
    private val differ = AsyncListDiffer(this, diffCallback)

    fun setData(items : List<HotelListUIModel>) {
        differ.submitList(items)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemHotelBinding.inflate(inflater, parent, false )

        return SearchListViewHolder(binding, onClickItem)
    }

    override fun onBindViewHolder(holder: SearchListViewHolder, position: Int) {
        differ.currentList.getOrNull(position)?.let {
            holder.bind(it)
        }
    }


    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<HotelListUIModel>() {
            override fun areItemsTheSame(oldItem: HotelListUIModel, newItem: HotelListUIModel, ): Boolean {
                return oldItem.requestId == newItem.requestId
            }

            override fun areContentsTheSame(oldItem: HotelListUIModel, newItem: HotelListUIModel, ): Boolean {
                return oldItem == newItem
            }

        }
    }

}

class SearchListViewHolder(private val binding: ListItemHotelBinding, val onClickItem : (HotelListUIModel)-> Unit) : RecyclerView.ViewHolder(binding.root) {

    fun bind(viewModel: HotelListUIModel) {
        binding.txt.text = viewModel.hotelName
        binding.root.setOnClickListener {

        }
    }

}
