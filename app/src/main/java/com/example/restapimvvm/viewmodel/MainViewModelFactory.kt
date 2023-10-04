package com.example.restapimvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.restapimvvm.viewmodel.repo.PostsRepository
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val repository: PostsRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}