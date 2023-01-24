package com.example.readermanga.data.di

import com.example.readermanga.data.remote.auth.AuthApi
import com.example.readermanga.data.remote.auth.AuthRepositoryImpl
import com.example.readermanga.domain.repository.auth.AuthRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val baseUrl = "http://134.122.75.14:8666/"

val dataModule = module {

    single { AuthApi(retrofit = get()) }

    single<AuthRepository> { AuthRepositoryImpl(api = get()) }

    single {
        provideOkHttp()
    }
    single {
        provideRetrofit(client = get())
    }
}

private fun provideRetrofit(
    client: OkHttpClient
) = Retrofit.Builder()
    .client(client)
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(baseUrl)
    .build()

private fun provideOkHttp() = OkHttpClient.Builder()
    .connectTimeout(15, TimeUnit.SECONDS)
    .readTimeout(10, TimeUnit.SECONDS)
    .writeTimeout(10, TimeUnit.SECONDS)
    .addInterceptor(
        HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    )
    .build()