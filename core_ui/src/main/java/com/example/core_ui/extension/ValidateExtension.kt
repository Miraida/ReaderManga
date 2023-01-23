package com.example.core_ui.extension

import androidx.annotation.StringRes
import com.example.core_ui.R


private const val MIN_LENGTH_USER_NAME = 1
private const val MIN_LENGTH_USER_PASSWORD = 4

enum class UserValidationError(@StringRes val res: Int) {
    TOO_SHORT_PASSWORD(R.string.error_short_password),
    EMPTY_PASSWORD(R.string.error_input_password),
    EMPTY_USER_NAME(R.string.error_input_user_name),
}

sealed class ValidationResult {
    object Validated : ValidationResult()
    class ValidateError(val error: UserValidationError) : ValidationResult()
}

fun String?.validatePassword(): ValidationResult {
    return if (this == null || this == "") ValidationResult.ValidateError(UserValidationError.EMPTY_PASSWORD)
    else if (this.length < MIN_LENGTH_USER_PASSWORD) ValidationResult.ValidateError(
        UserValidationError.TOO_SHORT_PASSWORD
    )
    else ValidationResult.Validated
}

fun String?.validateName(): ValidationResult {
    return if (this != null && this.length >= MIN_LENGTH_USER_NAME) ValidationResult.Validated
    else ValidationResult.ValidateError(UserValidationError.EMPTY_USER_NAME)
}