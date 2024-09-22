package com.yongjincompany.core.domain.param.users

data class PostUserSignInParam(
    val accountId: String,
    val password: String,
)