package com.example.restapimvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restapimvvm.MyApplication
import com.example.restapimvvm.R
import com.example.restapimvvm.databinding.ActivityMainBinding
import com.example.restapimvvm.view.adapter.PostsAdapter
import com.example.restapimvvm.viewmodel.MainViewModel
import com.example.restapimvvm.viewmodel.MainViewModelFactory
import com.example.restapimvvm.viewmodel.repo.PostsRepository
import com.example.restapimvvm.viewmodel.service.Api
import com.example.restapimvvm.viewmodel.service.MyClient
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        (application as MyApplication).applicationDiComponent.inject(this)
        mainViewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]

        binding.postRv.layoutManager = LinearLayoutManager(this)
        mainViewModel.posts.observe(this) {
            binding.postRv.adapter = PostsAdapter(it)
        }
    }
}