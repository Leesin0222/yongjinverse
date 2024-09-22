package com.yongjincompany.core.data.remote.model.request.users

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UpdateMyInfoRequest(
    @SerialName("name") val name: String,
    @SerialName("profileUrl") val profileUrl: String,
)