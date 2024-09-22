package com.yongjincompany.core.domain.usecase.users


import com.yongjincompany.core.domain.param.users.PostUserSignInParam
import com.yongjincompany.core.domain.repository.UsersRepository
import javax.inject.Inject

class PostUserSignInUseCase @Inject constructor(
    private val usersRepository: UsersRepository
){
    suspend operator fun invoke(postUserSignInParam: PostUserSignInParam) {
        usersRepository.postUserSignIn(postUserSignInParam)
    }
}