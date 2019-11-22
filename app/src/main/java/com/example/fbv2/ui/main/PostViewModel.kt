package com.example.fbv2.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fbv2.model.PostModel
import com.example.fbv2.utils.ApiUtil
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

public class PostViewModel:ViewModel() {
    var postMutableLiveData=MutableLiveData<List<PostModel>>()
    val mApiClient = ApiUtil
    fun getPosts(){
        mApiClient.getServiceClass().allposts().enqueue(object :Callback,
            retrofit2.Callback<List<PostModel>> {
            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                Log.d("ApiCall", "can't call api ")
            }

            override fun onResponse(
                call: Call<List<PostModel>>,
                response: Response<List<PostModel>>
            ) {
                postMutableLiveData.postValue(response.body())
            }

        })

    }
}