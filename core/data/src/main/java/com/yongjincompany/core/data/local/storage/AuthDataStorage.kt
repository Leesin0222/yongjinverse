package com.yongjincompany.core.data.local.storage

import kotlinx.datetime.LocalDateTime


interface AuthDataStorage {
    fun setAccessToken(token: String)
    fun fetchAccessToken(): String
    fun clearAccessToken()

    fun setRefreshToken(token: String)
    fun fetchRefreshToken(): String
    fun clearRefreshToken()

    fun setExpiredAt(localDateTime: String)
    fun fetchExpiredAt(): LocalDateTime

    fun setId(id: String)
    fun fetchId(): String
    fun clearId()

    fun setPw(pw: String)
    fun fetchPw(): String
    fun clearPw()
}