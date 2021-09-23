package com.challenge.homefeeds.model.remote

import com.challenge.homefeeds.model.HomeFeedsPage
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface HomeFeedsService {

    @GET("test/home")
    fun getHomeFeeds(): Call<HomeFeedsPage>

    companion object {
        fun create(): HomeFeedsService {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(
                    GsonConverterFactory.create())
                .baseUrl("")
                .build()

            return retrofit.create(HomeFeedsService::class.java)
        }
    }

}
