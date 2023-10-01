package com.example.restapimvvm.viewmodel.service

import com.example.restapimvvm.model.data.PostsItem
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("/posts")
    suspend fun getPosts(): Response<List<PostsItem>>
}