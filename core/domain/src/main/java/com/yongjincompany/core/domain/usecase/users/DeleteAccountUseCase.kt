package com.yongjincompany.core.domain.usecase.users

import com.yongjincompany.core.domain.repository.UsersRepository
import javax.inject.Inject

class DeleteAccountUseCase @Inject constructor(
    private val usersRepository: UsersRepository
){
    suspend operator fun invoke() {
        usersRepository.deleteAccount()
    }
}