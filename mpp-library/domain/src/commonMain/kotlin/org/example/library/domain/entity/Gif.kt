/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package org.example.library.domain.entity

import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize

@Parcelize
data class Gif(
    val id: Int,
    val previewUrl: String,
    val gifUrl: String
) : Parcelable {

    internal constructor(entity: dev.icerock.moko.network.generated.models.Gif) : this(
        id = entity.url.hashCode(),
        previewUrl = requireNotNull(entity.images?.downsizedMedium?.url) { "api can't respond without preview image" },
        gifUrl = requireNotNull(entity.images?.original?.url) { "api can't respond without original image" }
    )
}
