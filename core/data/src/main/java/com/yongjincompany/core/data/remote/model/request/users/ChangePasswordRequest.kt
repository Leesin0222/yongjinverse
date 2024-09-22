package com.yongjincompany.core.data.remote.model.request.users

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChangePasswordRequest(
    @SerialName("new_password") val newPassword: String,
    @SerialName("old_password") val oldPassword: String
)