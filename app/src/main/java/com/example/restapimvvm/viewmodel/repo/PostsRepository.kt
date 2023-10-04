package com.example.restapimvvm.viewmodel.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.restapimvvm.model.data.PostsItem
import com.example.restapimvvm.viewmodel.service.Api
import javax.inject.Inject

class PostsRepository @Inject constructor(private val api: Api) {

    private val postsLiveData = MutableLiveData<List<PostsItem>>()

    val posts: LiveData<List<PostsItem>>
        get() = postsLiveData

    suspend fun getPosts() {
        val result = api.getPosts()
        if (result.isSuccessful && result.body() != null) {
        postsLiveData.postValue(result.body())
        }
    }


}