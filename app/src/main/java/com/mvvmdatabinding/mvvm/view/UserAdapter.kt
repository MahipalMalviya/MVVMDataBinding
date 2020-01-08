package com.mvvmdatabinding.mvvm.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.mvvmdatabinding.BR
import com.mvvmdatabinding.R
import com.mvvmdatabinding.mvvm.model.User

class UserAdapter(val list: ArrayList<User>): RecyclerView.Adapter<UserAdapter.ViewHolderDataBinding>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderDataBinding {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context), R.layout.layout_list_item,
            parent,false)
        return ViewHolderDataBinding(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolderDataBinding, position: Int) {
        holder.binding.setVariable(BR.user,list[position])
        holder.binding.executePendingBindings()
    }

    inner class ViewHolderDataBinding(val binding:ViewDataBinding): RecyclerView.ViewHolder(binding.root)
}