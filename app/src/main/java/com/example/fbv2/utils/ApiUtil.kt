package com.example.fbv2.utils

object ApiUtil : RetrofitAPI() {

    fun getServiceClass(): RetrofitInterface {
        return getRetrofit().create(RetrofitInterface::class.java)
    }

}