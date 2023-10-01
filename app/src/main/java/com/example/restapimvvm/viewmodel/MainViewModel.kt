package com.example.restapimvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.restapimvvm.model.data.PostsItem
import com.example.restapimvvm.viewmodel.repo.PostsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: PostsRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getPosts()
        }
    }
    val posts: LiveData<List<PostsItem>>
        get() = repository.posts
}