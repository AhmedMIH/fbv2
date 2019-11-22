package com.example.fbv2.utils

import com.example.fbv2.model.PostModel
import retrofit2.Call
import retrofit2.http.*


interface RetrofitInterface {
    @GET("posts")
    fun allposts(): Call<List<PostModel>>
}