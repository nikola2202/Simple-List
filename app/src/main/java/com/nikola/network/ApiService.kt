package com.nikola.network

import com.nikola.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("users")
    suspend fun getUserList(@Query("page")page:Int): UserResponse
}