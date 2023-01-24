package com.example.readermanga.data.remote.auth

import com.example.readermanga.domain.model.auth.Login
import com.example.readermanga.domain.model.auth.Register
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("/api/auth/signin/")
    suspend fun login(@Body login: Login): String

    @POST("/api/auth/signup/")
    suspend fun register(@Body register: Register): String

    companion object {
        operator fun invoke(retrofit: Retrofit) = retrofit.create<AuthApi>()
    }
}