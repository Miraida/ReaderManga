package com.example.readermanga.data.remote.auth

import com.example.core.common.Constants
import com.example.readermanga.domain.model.auth.Login
import com.example.readermanga.domain.model.auth.Register
import com.example.readermanga.domain.repository.auth.AuthRepository
import kotlinx.coroutines.withTimeout

class AuthRepositoryImpl(private val api: AuthApi) : AuthRepository {
    override suspend fun login(login: Login): String {
        return try {
            withTimeout(Constants.NETWORK_TIMEOUT) {
                api.login(login)
            }
        } catch (e: Throwable) {
            throw e
        }
    }

    override suspend fun register(register: Register): String {
        return try {
            withTimeout(Constants.NETWORK_TIMEOUT) {
                api.register(register)
            }
        } catch (t: Throwable) {
            throw t
        }
    }
}