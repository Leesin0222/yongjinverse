package com.yongjincompany.core.data.remote.api

import com.yongjincompany.core.data.remote.model.request.users.ChangePasswordRequest
import com.yongjincompany.core.data.remote.model.request.users.UpdateMyInfoRequest
import com.yongjincompany.core.data.remote.model.request.users.UserRegisterRequest
import com.yongjincompany.core.data.remote.model.request.users.UserSignInRequest
import com.yongjincompany.core.data.remote.model.response.users.FetchMyInfoResponse
import com.yongjincompany.core.data.remote.model.response.users.UserRegisterResponse
import com.yongjincompany.core.data.remote.model.response.users.UserSignInResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST

interface UserApi {
    @POST("users")
    suspend fun userRegister(
        @Body userSignUpRequest: UserRegisterRequest
    ): UserRegisterResponse

    @POST("users/auth")
    suspend fun userSignIn(
        @Body userSignInRequest: UserSignInRequest
    ): UserSignInResponse

    //TODO: api개선 필요. 일단 사용 X
    @PATCH("users")
    suspend fun updateMyInfo(
        @Body updateMyInfoRequest: UpdateMyInfoRequest
    )

    @GET("users")
    suspend fun fetchMyInfo(
    ): FetchMyInfoResponse

    @PATCH("users/password")
    suspend fun changePassword(
        @Body changePasswordRequest: ChangePasswordRequest
    )

    @DELETE("users")
    suspend fun logOut()

    @DELETE("users")
    suspend fun deleteAccount()
}