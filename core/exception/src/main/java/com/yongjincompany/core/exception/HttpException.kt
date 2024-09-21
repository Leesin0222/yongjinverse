package com.yongjincompany.core.exception

sealed class HttpException(
    val code: Int = DEFAULT_CODE,
    message: String?,
) : RuntimeException(message)

const val DEFAULT_CODE = -1