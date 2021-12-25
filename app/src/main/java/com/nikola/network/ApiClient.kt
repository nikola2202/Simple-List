package com.nikola.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {
    private fun getLoggingIntercepter() = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BASIC)
    private fun getOkHttpClient() = OkHttpClient.Builder()
        .addInterceptor(getLoggingIntercepter())
        .build()

    private fun getClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("")
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService = getClient().create(ApiService::class.java)
}