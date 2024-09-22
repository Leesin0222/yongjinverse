package com.yongjincompany.core.data.remote.datasource

import com.yongjincompany.core.data.handler.sendHttpRequest
import com.yongjincompany.core.data.remote.api.UserApi
import com.yongjincompany.core.data.remote.model.request.users.ChangePasswordRequest
import com.yongjincompany.core.data.remote.model.request.users.UpdateMyInfoRequest
import com.yongjincompany.core.data.remote.model.request.users.UserRegisterRequest
import com.yongjincompany.core.data.remote.model.request.users.UserSignInRequest
import com.yongjincompany.core.data.remote.model.response.users.FetchMyInfoResponse
import com.yongjincompany.core.data.remote.model.response.users.UserRegisterResponse
import com.yongjincompany.core.data.remote.model.response.users.UserSignInResponse
import javax.inject.Inject

class RemoteUserDataSourceImpl @Inject constructor(
    private val usersApi: UserApi
) : RemoteUsersDataSource {
    override suspend fun postUserRegister(userRegisterRequest: UserRegisterRequest): UserRegisterResponse {
        return sendHttpRequest { usersApi.userRegister(userRegisterRequest) }
    }

    override suspend fun postUserSignIn(userSignInRequest: UserSignInRequest): UserSignInResponse {
        return sendHttpRequest { usersApi.userSignIn(userSignInRequest) }
    }

    override suspend fun updateMyInfo(updateMyInfoRequest: UpdateMyInfoRequest) {
        sendHttpRequest { usersApi.updateMyInfo(updateMyInfoRequest) }
    }

    override suspend fun fetchMyInfo(): FetchMyInfoResponse {
        return sendHttpRequest { usersApi.fetchMyInfo() }
    }

    override suspend fun changePassword(changePasswordRequest: ChangePasswordRequest) {
        sendHttpRequest { usersApi.changePassword(changePasswordRequest) }
    }

    override suspend fun logOut() {
        sendHttpRequest { usersApi.logOut() }
    }

    override suspend fun deleteAccount() {
        sendHttpRequest { usersApi.deleteAccount() }
    }
}