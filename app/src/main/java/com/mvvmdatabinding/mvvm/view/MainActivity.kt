package com.mvvmdatabinding.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mvvmdatabinding.R
import com.mvvmdatabinding.databinding.ActivityMainBinding
import com.mvvmdatabinding.mvvm.model.User
import com.mvvmdatabinding.mvvm.viewModel.UserViewModel

class MainActivity : AppCompatActivity() {

    private var list = ArrayList<User>()
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

        val viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(UserViewModel::class.java)

        val recyclerView = binding.rvUserDetails
        recyclerView.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)

        adapter = UserAdapter(list)
        recyclerView.adapter = adapter


        viewModel.getUserList().observe(this, Observer { response ->
            if (response?.data != null) {
                if (list.isNotEmpty()) {
                    list.clear()
                }
                list.addAll(response.data)
                adapter.notifyDataSetChanged()
            }
        })
    }
}
