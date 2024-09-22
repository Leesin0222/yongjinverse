package com.yongjincompany.core.domain.repository

import com.yongjincompany.core.domain.entity.users.FetchMyInfoEntity
import com.yongjincompany.core.domain.param.users.ChangePasswordParam
import com.yongjincompany.core.domain.param.users.PostUserRegisterParam
import com.yongjincompany.core.domain.param.users.PostUserSignInParam
import com.yongjincompany.core.domain.param.users.UpdateMyInfoParam

interface UsersRepository {
    suspend fun postUserRegister(
        postUserRegisterParam: PostUserRegisterParam,
    )

    suspend fun postUserSignIn(
        postUserSignInParam: PostUserSignInParam,
    )

    suspend fun autoLogin()

    suspend fun updateMyInfo(
        updateMyInfoParam: UpdateMyInfoParam,
    )

    suspend fun fetchMyInfo(): FetchMyInfoEntity

    suspend fun changePassword(
        changePasswordParam: ChangePasswordParam
    )

    suspend fun logOut()

    suspend fun deleteAccount()
}