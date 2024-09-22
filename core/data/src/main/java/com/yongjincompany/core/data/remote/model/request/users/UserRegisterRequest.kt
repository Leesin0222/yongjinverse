package com.yongjincompany.core.data.remote.model.request.users

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserRegisterRequest(
    @SerialName("account_id") val accountId: String,
    @SerialName("name") val name: String,
    @SerialName("password") val password: String
)