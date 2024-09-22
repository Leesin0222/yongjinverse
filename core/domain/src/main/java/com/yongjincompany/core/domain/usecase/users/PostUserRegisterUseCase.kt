package com.yongjincompany.core.domain.usecase.users


import com.yongjincompany.core.domain.param.users.PostUserRegisterParam
import com.yongjincompany.core.domain.repository.UsersRepository
import javax.inject.Inject

class PostUserRegisterUseCase @Inject constructor(
    private val usersRepository: UsersRepository
){
    suspend operator fun invoke(postUserRegisterParam: PostUserRegisterParam) {
        usersRepository.postUserRegister(postUserRegisterParam)
    }
}