package com.moonlyte.assignmentmoonlyte.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.moonlyte.assignmentmoonlyte.common.BindableAdapter

@BindingAdapter("dataList")
fun <T: Any> setRecyclerViewListData(recyclerView: RecyclerView, list: List<T>?){
    if (recyclerView.adapter is BindableAdapter<*>){
        (recyclerView.adapter as BindableAdapter<T>).setDataList(list)
    }
}
