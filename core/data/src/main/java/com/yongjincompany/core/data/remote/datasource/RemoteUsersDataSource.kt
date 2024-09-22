package com.yongjincompany.core.data.remote.datasource

import com.yongjincompany.core.data.remote.model.request.users.ChangePasswordRequest
import com.yongjincompany.core.data.remote.model.request.users.UpdateMyInfoRequest
import com.yongjincompany.core.data.remote.model.request.users.UserRegisterRequest
import com.yongjincompany.core.data.remote.model.request.users.UserSignInRequest
import com.yongjincompany.core.data.remote.model.response.users.FetchMyInfoResponse
import com.yongjincompany.core.data.remote.model.response.users.UserRegisterResponse
import com.yongjincompany.core.data.remote.model.response.users.UserSignInResponse

interface RemoteUsersDataSource {
    suspend fun postUserRegister(
        userRegisterRequest: UserRegisterRequest,
    ): UserRegisterResponse

    suspend fun postUserSignIn(
        userSignInRequest: UserSignInRequest,
    ): UserSignInResponse

    suspend fun updateMyInfo(
        updateMyInfoRequest: UpdateMyInfoRequest,
    )

    suspend fun fetchMyInfo(
    ): FetchMyInfoResponse

    suspend fun changePassword(
        changePasswordRequest: ChangePasswordRequest
    )

    suspend fun logOut()

    suspend fun deleteAccount()
}