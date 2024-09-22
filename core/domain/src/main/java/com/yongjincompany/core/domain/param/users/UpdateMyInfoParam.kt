package com.yongjincompany.core.domain.param.users

import java.io.File

data class UpdateMyInfoParam(
    val name: String,
    val profileUrl: File,
)
