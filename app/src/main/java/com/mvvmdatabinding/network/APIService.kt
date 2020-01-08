package com.mvvmdatabinding.network

import com.mvvmdatabinding.mvvm.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("/api/users?page=2")
    fun getUserList(): Call<UserResponse>
}