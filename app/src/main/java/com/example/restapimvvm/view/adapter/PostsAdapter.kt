package com.example.restapimvvm.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.restapimvvm.R
import com.example.restapimvvm.model.data.PostsItem

class PostsAdapter(private val list: List<PostsItem>) :
    RecyclerView.Adapter<PostsAdapter.Holder>() {

    class Holder(itemView: View) : ViewHolder(itemView) {
        private val userIdTextView: TextView = itemView.findViewById(R.id.textViewUserId)
        private val titleTextView: TextView = itemView.findViewById(R.id.textViewTitle)
        private val bodyTextView: TextView = itemView.findViewById(R.id.textViewBody)

        fun bind(userId: Int, title: String, body: String) {
            userIdTextView.text = "User ID: $userId"
            titleTextView.text = "Title: $title"
            bodyTextView.text = "Body: $body"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.row, parent, false)
        return Holder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val postsItem = list[position]
        holder.bind(postsItem.userId, postsItem.title, postsItem.body)
        holder.itemView.setOnClickListener {
            Log.d("RV ", "id ${postsItem.id}")
        }
    }
}