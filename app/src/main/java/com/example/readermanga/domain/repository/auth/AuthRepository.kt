package com.example.readermanga.domain.repository.auth

import com.example.core.common.ResultStatus
import com.example.readermanga.domain.model.auth.Login
import com.example.readermanga.domain.model.auth.Register
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(login: Login): String
    suspend fun register(register: Register): String
}