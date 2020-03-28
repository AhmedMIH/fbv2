package com.example.fbv2.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fbv2.R
import com.example.fbv2.network.PostModel


class PostsAdapter(var postModel: List<PostModel>) : RecyclerView.Adapter<PostsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.post_item, parent, false)
        return PostsHolder(view)
    }

    override fun getItemCount(): Int {
        return postModel.size
    }

    override fun onBindViewHolder(holder: PostsHolder, position: Int) {
        holder.onBind(postModel[position])
    }
}

class PostsHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun onBind(postModel: PostModel) {
        val titleTV=itemView.findViewById<TextView>(R.id.titleTV)
        val userIDTV=itemView.findViewById<TextView>(R.id.userIDTV)
        val bodyTV=itemView.findViewById<TextView>(R.id.bodyTV)
        titleTV.text=postModel.title
        userIDTV.text= postModel.userId.toString()
        bodyTV.text=postModel.body
    }
}

