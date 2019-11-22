package com.example.fbv2.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fbv2.R
import com.example.fbv2.model.PostModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ViewModel: PostViewModel by lazy {
            ViewModelProviders.of(this).get(PostViewModel::class.java)
        }
        val Result:Observer<List<PostModel>> = Observer{
            showInView(it)
        }
        ViewModel.getPosts()
        ViewModel.postMutableLiveData.observe(this,Result)
    }

    fun showInView(PostList: List<PostModel>){
        val postsAdapter=PostsAdapter(PostList)
        var recyclerView=findViewById<RecyclerView>(R.id.recycler)
        recyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter=postsAdapter
    }
}
