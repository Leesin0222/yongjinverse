package com.yongjincompany.core.domain.param.users

data class ChangePasswordParam(
    val oldPassword: String,
    val newPassword: String
)
