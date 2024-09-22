package com.yongjincompany.core.data.remote.model.response.users

import com.yongjincompany.core.domain.entity.users.FetchMyInfoEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class FetchMyInfoResponse(
    @SerialName("name") val name: String,
    @SerialName("profile_image_url") val profileImageUrl: String,
    @SerialName("rank") val rank: Int,
    @SerialName("coin") val coin: Int,
    @SerialName("user_id") val userId: Long,
    @SerialName("card_count") val cardCount: CardCount,
) {
    @Serializable
    data class CardCount(
        @SerialName("agrade_card_count") val agradeCardCount: Int,
        @SerialName("bgrade_card_count") val bgradeCardCount: Int,
        @SerialName("cgrade_card_count") val cgradeCardCount: Int,
        @SerialName("sgrade_card_count") val sgradeCardCount: Int,
        @SerialName("dgrade_card_count") val dgradeCardCount: Int,
    )

    fun CardCount.toEntity() =
        FetchMyInfoEntity.CardCount(
            agradeCardCount = agradeCardCount,
            bgradeCardCount = bgradeCardCount,
            cgradeCardCount = cgradeCardCount,
            sgradeCardCount = sgradeCardCount,
            dgradeCardCount = dgradeCardCount
        )
}

fun FetchMyInfoResponse.toEntity() =
    FetchMyInfoEntity(
        name = name,
        profileImageUrl = profileImageUrl,
        rank = rank,
        coin = coin,
        userId = userId,
        cardCount = cardCount.toEntity()
    )