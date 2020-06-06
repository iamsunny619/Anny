package com.example.anny.ui.utils

import androidx.annotation.IntDef

const val RULE_NOT_EMPTY = 1
const val RULE_NOT_EMAIL = 2
const val RULE_NOT_LENGTH_5 = 3
const val RULE_NOT_LENGTH_15 = 4


@IntDef(
    value = [
        RULE_NOT_EMPTY,
        RULE_NOT_EMAIL,
        RULE_NOT_LENGTH_5,
        RULE_NOT_LENGTH_15
    ]
)
@Retention(AnnotationRetention.SOURCE)
annotation class Validations

private val emailPattern = Regex("[A-Z0-9a-z\\.]+@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}")

fun CharSequence.isEmailValid() = matches(emailPattern)