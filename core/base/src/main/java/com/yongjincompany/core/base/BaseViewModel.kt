package com.yongjincompany.core.base

import androidx.lifecycle.ViewModel
import com.yongjincompany.core.exception.NoInternetException
import com.yongjincompany.core.exception.TimeoutException
import com.yongjincompany.core.exception.TooManyRequestsException
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

abstract class BaseViewModel : ViewModel() {
    private val _baseEvent = MutableSharedFlow<BaseEvent>()
    val baseEvent = _baseEvent.asSharedFlow()

    protected suspend fun handleCommonExceptions(
        exception: Throwable,
        customErrorMessage: String = "용니버스가 잠시 다른 차원으로 이동 중이에요. 잠시 후 다시 시도해주세요",
        captureMessage: String = "empty",
        errorToastEnable: Boolean = true,
        errorCaptureEnable: Boolean = false
    ) {
        when (exception) {
            is NoInternetException -> _baseEvent.emit(BaseEvent.ErrorMessage("인터넷 연결을 확인하고 다시 시도해주세요"))
            is TimeoutException -> _baseEvent.emit(BaseEvent.ErrorMessage("서버와 연결이 끊어졌어요. 다시 시도해주세요"))
            is TooManyRequestsException -> { _baseEvent.emit(BaseEvent.ErrorMessage("너무 많은 요청이에요. 다시 시도해주세요")) }

            else -> {
                if (errorToastEnable) {
                    _baseEvent.emit(BaseEvent.ErrorMessage(customErrorMessage))
                }

                if (errorCaptureEnable) {
                    //TODO : Sentry대신, Firebase crashlytics사용해보기
                    //Sentry.captureMessage("exception: ${exception}, captureMessage: ${captureMessage} ,customErrorMessage: ${customErrorMessage}")
                }
            }
        }
    }

    sealed class BaseEvent {
        data class ErrorMessage(val message: String) : BaseEvent()
    }
}