package com.moonlyte.assignmentmoonlyte.features.account.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.moonlyte.assignmentmoonlyte.BR
import com.moonlyte.assignmentmoonlyte.R
import com.moonlyte.assignmentmoonlyte.common.BindableAdapter
import com.moonlyte.assignmentmoonlyte.features.account.model.Users

internal class UsersAdapter : RecyclerView.Adapter<UsersAdapter.ViewHolder>(),BindableAdapter<Users> {

    private var userList: List<Users> = emptyList()

    override fun setDataList(userList: List<Users>?) {
        userList?.let {
            this.userList = it
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewDataBinding: ViewDataBinding = DataBindingUtil.inflate(inflater, viewType, parent, false)

        return ViewHolder(viewDataBinding)
    }

    override fun getItemCount(): Int = userList.size

    override fun getItemViewType(position: Int): Int = R.layout.item_users_list_card_view

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    class ViewHolder(private val viewDataBinding: ViewDataBinding) : RecyclerView.ViewHolder(viewDataBinding.root) {

        fun bind(users: Users) {
            this.viewDataBinding.setVariable(BR.users,users)
        }
    }
}