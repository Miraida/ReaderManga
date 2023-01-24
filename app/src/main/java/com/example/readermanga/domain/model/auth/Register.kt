package com.example.readermanga.domain.model.auth

data class Register(
    val username: String,
    val nickname: String,
    val password: String,
    val image_file: String
)
