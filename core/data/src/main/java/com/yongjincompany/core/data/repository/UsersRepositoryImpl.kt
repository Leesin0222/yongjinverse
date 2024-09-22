package com.yongjincompany.core.data.repository

import com.yongjincompany.core.data.local.storage.AuthDataStorage
import com.yongjincompany.core.data.remote.datasource.RemoteUsersDataSource
import com.yongjincompany.core.data.remote.model.request.users.ChangePasswordRequest
import com.yongjincompany.core.data.remote.model.request.users.UpdateMyInfoRequest
import com.yongjincompany.core.data.remote.model.request.users.UserRegisterRequest
import com.yongjincompany.core.data.remote.model.request.users.UserSignInRequest
import com.yongjincompany.core.data.remote.model.response.users.UserSignInResponse
import com.yongjincompany.core.data.remote.model.response.users.toEntity
import com.yongjincompany.core.domain.entity.users.FetchMyInfoEntity
import com.yongjincompany.core.domain.param.users.ChangePasswordParam
import com.yongjincompany.core.domain.param.users.PostUserRegisterParam
import com.yongjincompany.core.domain.param.users.PostUserSignInParam
import com.yongjincompany.core.domain.param.users.UpdateMyInfoParam
import com.yongjincompany.core.domain.repository.UsersRepository
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val authDataStorage: AuthDataStorage,
    private val remoteUsersDataSource: RemoteUsersDataSource,
) : UsersRepository {
    override suspend fun postUserRegister(
        postUserRegisterParam: PostUserRegisterParam,
    ) {
        val postUserSignInParam = PostUserSignInParam(
            accountId = postUserRegisterParam.accountId,
            password = postUserRegisterParam.password
        )
        val response = remoteUsersDataSource.postUserRegister(postUserRegisterParam.toRequest())
        saveAccount(postUserSignInParam)
        saveTokenSignUp(
            accessToken = response.accessToken,
            refreshToken = response.refreshToken,
            expiredAt = response.expiredAt
        )
    }

    override suspend fun postUserSignIn(
        postUserSignInParam: PostUserSignInParam,
    ) {
        val response = remoteUsersDataSource.postUserSignIn(postUserSignInParam.toRequest())
        saveAccount(postUserSignInParam)
        saveToken(response)
    }

    override suspend fun autoLogin() {
        remoteUsersDataSource.postUserSignIn(
            UserSignInRequest(
                authDataStorage.fetchId(),
                authDataStorage.fetchPw()
            )
        )
    }

    override suspend fun updateMyInfo(updateMyInfoParam: UpdateMyInfoParam) {
        //TODO: api개선 필요

        /*  val imageUrl = if (updateMyInfoParam.profileUrl != null) {
              remoteImagesDataSource.postImages(
                  listOf(updateMyInfoParam.profileUrl!!.toMultipart())
              ).imageUrl.first()
          } else ""
  */
       // remoteUsersDataSource.updateMyInfo(updateMyInfoParam.toRequest(imageUrl))
    }

    override suspend fun fetchMyInfo(): FetchMyInfoEntity =
        remoteUsersDataSource.fetchMyInfo().toEntity()


    private fun saveToken(userSignInResponse: UserSignInResponse) {
        authDataStorage.apply {
            setAccessToken(userSignInResponse.accessToken)
            setRefreshToken(userSignInResponse.refreshToken)
            setExpiredAt(userSignInResponse.expiredAt)
        }
    }

    private fun saveTokenSignUp(
        accessToken: String,
        refreshToken: String,
        expiredAt: String,
    ) {
        authDataStorage.apply {
            setAccessToken(accessToken)
            setRefreshToken(refreshToken)
            setExpiredAt(expiredAt)
        }
    }

    private fun saveAccount(userSignInParam: PostUserSignInParam) {
        authDataStorage.apply {
            setId(userSignInParam.accountId)
            setPw(userSignInParam.password)
        }
    }

    override suspend fun changePassword(
        changePasswordParam: ChangePasswordParam
    ) {
        remoteUsersDataSource.changePassword(changePasswordParam.toRequest())
    }

    override suspend fun logOut() {
        remoteUsersDataSource.logOut()
        authDataStorage.apply {
            clearId()
            clearPw()
            clearAccessToken()
            clearRefreshToken()
        }
    }

    override suspend fun deleteAccount() {
        remoteUsersDataSource.deleteAccount()
    }

    private fun PostUserRegisterParam.toRequest() =
        UserRegisterRequest(
            accountId = accountId,
            password = password,
            name = name
        )

    private fun PostUserSignInParam.toRequest() =
        UserSignInRequest(
            accountId = accountId,
            password = password
        )

    private fun UpdateMyInfoParam.toRequest(profileUrl: String) =
        UpdateMyInfoRequest(
            name = name,
            profileUrl = profileUrl
        )

    private fun ChangePasswordParam.toRequest() =
        ChangePasswordRequest(
            oldPassword = oldPassword,
            newPassword = newPassword
        )

}