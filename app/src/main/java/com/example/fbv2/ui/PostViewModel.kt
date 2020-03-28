package com.example.fbv2.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fbv2.network.PostModel
import com.example.fbv2.network.PostsApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PostViewModel:ViewModel() {
    private val _response = MutableLiveData<List<PostModel>>()
    val response: LiveData<List<PostModel>>
        get() = _response

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(
        viewModelJob + Dispatchers.Main )

     init {
         getPosts()
     }


    private fun getPosts(){
        coroutineScope.launch {
            val getPosts= PostsApi.RETROFIT_SERVICE.allPosts()
            try {
                val listPost= getPosts.await()
                _response.value=listPost
            }
            catch (e:Exception){
                print("error")
            }
        }
    }

     override fun onCleared() {
         super.onCleared()
         viewModelJob.cancel()
     }
}