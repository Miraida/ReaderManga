package com.example.readermanga.domain.use_case.auth

import com.example.core.common.ResultStatus
import com.example.readermanga.domain.model.auth.Login
import com.example.readermanga.domain.repository.auth.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class LoginUseCase(private val authRepository: AuthRepository) {

    operator fun invoke(login: Login): Flow<ResultStatus<String>> = flow {

        emit(ResultStatus.Loading())

        try {
            emit(ResultStatus.Success(authRepository.login(login)))
        } catch (e: Throwable) {
            emit(ResultStatus.Error(e.message ?: "Unknown error"))
        }

    }.flowOn(Dispatchers.IO)
}