package com.yongjincompany.core.domain.usecase.users

import com.yongjincompany.core.domain.param.users.ChangePasswordParam
import com.yongjincompany.core.domain.repository.UsersRepository
import javax.inject.Inject

class ChangePasswordUseCase @Inject constructor(
    private val usersRepository: UsersRepository
) {
    suspend operator fun invoke(changePasswordParam: ChangePasswordParam) {
        return usersRepository.changePassword(changePasswordParam)
    }
}