package com.yongjincompany.core.data.remote.model.response.users

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserRegisterResponse(
    @SerialName("access_token")val accessToken: String,
    @SerialName("expired_at") val expiredAt: String,
    @SerialName("refresh_token") val refreshToken: String
)