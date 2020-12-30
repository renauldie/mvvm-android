package com.rynn.tokoku.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitApi {
    const val NEWS_URL = "https://www.news.developeridn.com/teknologi/"

    private val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })

        .readTimeout(10, TimeUnit.SECONDS)
        .connectTimeout(10, TimeUnit.SECONDS)
        .build()

    private fun create(url: String) : Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client((client))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }

    fun newsService() : NewsService {
        return create(NEWS_URL).create((NewsService::class.java))
    }
}