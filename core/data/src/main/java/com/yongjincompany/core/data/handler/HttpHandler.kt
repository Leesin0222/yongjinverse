package com.yongjincompany.core.data.handler

import com.yongjincompany.core.exception.BadRequestException
import com.yongjincompany.core.exception.ConflictException
import com.yongjincompany.core.exception.ForbiddenException
import com.yongjincompany.core.exception.NoInternetException
import com.yongjincompany.core.exception.NotFoundException
import com.yongjincompany.core.exception.RequestTimeoutException
import com.yongjincompany.core.exception.ServerException
import com.yongjincompany.core.exception.TimeoutException
import com.yongjincompany.core.exception.TooManyRequestsException
import com.yongjincompany.core.exception.UnauthorizedException
import com.yongjincompany.core.exception.UnknownException
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

suspend inline fun <T> sendHttpRequest(
    //code와 message가 response로 내려오지 않는경우를 고려하여 messaage를 nullable하게 .
    onBadRequest: (message: String?) -> Nothing = { throw BadRequestException() },
    onUnauthorized: (message: String?) -> Nothing = { throw UnauthorizedException() },
    onForbidden: (message: String?) -> Nothing = { throw ForbiddenException() },
    onNotFound: (message: String?) -> Nothing = { throw NotFoundException() },
    onRequestTimeOut: (message: String?) -> Nothing = { throw RequestTimeoutException() },
    onConflict: (message: String?) -> Nothing = { throw ConflictException() },
    onTooManyRequest: (message: String?) -> Nothing = { throw TooManyRequestsException() },
    onServerError: (message: String?) -> Nothing = { throw ServerException() },
    onUnknownException: (message: String?) -> Nothing = { throw UnknownException() },
    crossinline request: suspend () -> T,
): T = try {
    request()
} catch (e: HttpException) {
    val code = e.code()
    val message = e.message()

    require(code in 400 until 600) {
        "status code must be in 400 until 600"
    }

    when (code) {
        400 -> onBadRequest(message)
        401 -> onUnauthorized(message)
        403 -> onForbidden(message)
        404 -> onNotFound(message)
        408 -> onRequestTimeOut(message)
        409 -> onConflict(message)
        429 -> onTooManyRequest(message)
        in 400 until 500 -> onUnknownException(message)
        500 -> onServerError(message)
        else -> onUnknownException(message)
    }
} catch (e: UnknownHostException) {
    throw NoInternetException()
} catch (e: SocketTimeoutException) {
    throw TimeoutException()
}