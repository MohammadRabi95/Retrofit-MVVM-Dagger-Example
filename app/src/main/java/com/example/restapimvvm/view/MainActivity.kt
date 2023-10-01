package com.example.restapimvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restapimvvm.R
import com.example.restapimvvm.databinding.ActivityMainBinding
import com.example.restapimvvm.view.adapter.PostsAdapter
import com.example.restapimvvm.viewmodel.MainViewModel
import com.example.restapimvvm.viewmodel.MainViewModelFactory
import com.example.restapimvvm.viewmodel.repo.PostsRepository
import com.example.restapimvvm.viewmodel.service.Api
import com.example.restapimvvm.viewmodel.service.MyClient

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val myClient = MyClient.getInstance().create(Api::class.java)
        val repository = PostsRepository(myClient)

        val viewModel =
            ViewModelProvider(this, MainViewModelFactory(repository))[MainViewModel::class.java]

        binding.postRv.layoutManager = LinearLayoutManager(this)
        viewModel.posts.observe(this) {
            binding.postRv.adapter = PostsAdapter(it)
        }
    }
}