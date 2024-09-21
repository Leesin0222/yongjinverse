package com.yongjincompany.core.exception

class BadRequestException : HttpException(code = 400, message = "BadRequest")

class ConflictException : HttpException(code = 409, message = "Conflict")

class ForbiddenException : HttpException(code = 403, message = "Forbidden")


class NotFoundException : HttpException(code = 404, message = "NotFound")

class ServerException : HttpException(code = 500, message = "Server")

class RequestTimeoutException : HttpException(code = 408, message = "Server")

class TooManyRequestsException : HttpException(code = 429, message = "TooManyRequest")

class UnauthorizedException : HttpException(code = 401, message = "Unauthorized")


class NoInternetException : RuntimeException()
class TimeoutException : RuntimeException()
class UnknownException : RuntimeException("Unknown")