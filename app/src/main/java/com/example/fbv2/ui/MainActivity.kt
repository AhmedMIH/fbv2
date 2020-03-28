package com.example.fbv2.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fbv2.R
import com.example.fbv2.network.PostModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel: PostViewModel by lazy {
            ViewModelProvider(this).get(PostViewModel::class.java)
        }

        viewModel.response.observe(this, Observer {
            showInView(it)
        })

    }

    private fun showInView(PostList: List<PostModel>){
        val postsAdapter= PostsAdapter(PostList)
        val recyclerView=findViewById<RecyclerView>(R.id.recycler)
        recyclerView.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter=postsAdapter
    }
}
