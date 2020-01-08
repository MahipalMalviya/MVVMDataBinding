package com.mvvmdatabinding.mvvm.model

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.annotations.SerializedName

data class User (

	@SerializedName("id") val id : Int,
	@SerializedName("email") val email : String,
	@SerializedName("first_name") val first_name : String,
	@SerializedName("last_name") val last_name : String,
	@SerializedName("avatar") val avatar : String
) {
	companion object {
		@JvmStatic
		@BindingAdapter("android:src")
		fun imageLoad(imageView: AppCompatImageView,url:String) {
	    	Glide.with(imageView.context)
				.setDefaultRequestOptions(RequestOptions().circleCrop())
				.load(url)
				.into(imageView)
		}
	}
}