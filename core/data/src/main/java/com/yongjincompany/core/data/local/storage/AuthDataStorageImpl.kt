package com.yongjincompany.core.data.local.storage

import android.content.Context
import android.preference.PreferenceManager
import com.yongjincompany.core.data.local.storage.AuthDataStorageImpl.Key.ACCESS_TOKEN
import com.yongjincompany.core.data.local.storage.AuthDataStorageImpl.Key.ACCOUNT_ID
import com.yongjincompany.core.data.local.storage.AuthDataStorageImpl.Key.ACCOUNT_PASSWORD
import com.yongjincompany.core.data.local.storage.AuthDataStorageImpl.Key.EXPIRED_AT
import com.yongjincompany.core.data.local.storage.AuthDataStorageImpl.Key.REFRESH_TOKEN
import com.yongjincompany.core.data.util.now
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.toLocalDateTime
import javax.inject.Inject

class AuthDataStorageImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : AuthDataStorage {

    override fun setAccessToken(token: String) {
        getSharedPreference().edit().let {
            it.putString(ACCESS_TOKEN, token)
            it.apply()
        }
    }

    override fun fetchAccessToken(): String =
        getSharedPreference().getString(ACCESS_TOKEN, "empty")!!

    override fun clearAccessToken() {
        getSharedPreference().edit().let {
            it.remove(ACCESS_TOKEN)
            it.apply()
        }
    }

    override fun setRefreshToken(token: String) {
        getSharedPreference().edit().let {
            it.putString(REFRESH_TOKEN, "empty")
            it.apply()
        }
    }

    override fun fetchRefreshToken(): String =
        getSharedPreference().getString(REFRESH_TOKEN, "empty")!!

    override fun clearRefreshToken() {
        getSharedPreference().edit().let {
            it.remove(REFRESH_TOKEN)
            it.apply()
        }
    }

    override fun setExpiredAt(localDateTime: String) {
        getSharedPreference().edit().let {
            it.putString(EXPIRED_AT, localDateTime)
            it.apply()
        }
    }

    override fun fetchExpiredAt(): LocalDateTime =
        getSharedPreference().getString(EXPIRED_AT, LocalDateTime.now().toString())?.toLocalDateTime()!!

    override fun setId(id: String) {
        getSharedPreference().edit().let {
            it.putString(ACCOUNT_ID, id)
            it.apply()
        }
    }

    override fun fetchId(): String =
        getSharedPreference().getString(ACCOUNT_ID, "empty")!!

    override fun clearId() {
        getSharedPreference().edit().let {
            it.remove(ACCOUNT_ID)
            it.apply()
        }
    }

    override fun setPw(pw: String) {
        getSharedPreference().edit().let {
            it.putString(ACCOUNT_PASSWORD, pw)
            it.apply()
        }
    }

    override fun fetchPw(): String =
        getSharedPreference().getString(ACCOUNT_PASSWORD, "empty")!!

    override fun clearPw() {
        getSharedPreference().edit().let {
            it.remove(ACCOUNT_PASSWORD)
            it.apply()
        }
    }

    private fun getSharedPreference() =
        PreferenceManager.getDefaultSharedPreferences(context)

    private object Key {
        const val ACCESS_TOKEN = "ACCESS_TOKEN"
        const val REFRESH_TOKEN = "REFRESH_TOKEN"
        const val EXPIRED_AT = "EXPIRED_AT"
        const val DEVICE_TOKEN = "DEVICE_TOKEN"
        const val ACCOUNT_ID = "ACCOUNT_ID"
        const val ACCOUNT_PASSWORD = "ACCOUNT_PASSWORD"
    }
}