package com.mvvmdatabinding.mvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mvvmdatabinding.mvvm.model.UserResponse
import com.mvvmdatabinding.network.APIClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel: ViewModel() {

    private var userLiveData = MutableLiveData<UserResponse>()

    fun getUserList() : LiveData<UserResponse>{
        val call = APIClient.getInstance()?.getUserList()

        call?.enqueue(object : Callback<UserResponse> {
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    userLiveData.value = response.body()
                }
            }
        })
        return userLiveData
    }
}