package com.yongjincompany.core.data.remote.model.response.users

import kotlinx.serialization.SerialName


data class UserSignInResponse(
    @SerialName("access_token")val accessToken: String,
    @SerialName("expired_at") val expiredAt: String,
    @SerialName("refresh_token") val refreshToken: String
)