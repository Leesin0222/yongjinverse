package com.yongjincompany.core.domain.param.users

data class PostUserRegisterParam(
    val accountId: String,
    val name: String,
    val password: String,
)