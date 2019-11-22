package com.example.fbv2.utils

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

//fixed RetrofitAPI
open class RetrofitAPI {
    private val baseUrl = "https://jsonplaceholder.typicode.com/"
    private val moshi: Moshi = Moshi.Builder().build()
    var retrofitInterface:RetrofitInterface?=null
    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

}

