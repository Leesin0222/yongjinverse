package com.yongjincompany.core.data.remote.model.request.users

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserSignInRequest(
    @SerialName("account_id") val accountId: String,
    @SerialName("password") val password: String
)