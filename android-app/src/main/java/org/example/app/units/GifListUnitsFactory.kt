/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package org.example.app.units

import dev.icerock.moko.units.UnitItem
import org.example.app.TileGif
import org.example.library.SharedFactory

class GifListUnitsFactory : SharedFactory.GifsUnitsFactory {
    override fun createGifTile(id: Long, gifUrl: String): UnitItem {
        return TileGif().apply {
            itemId = id
            this.gifUrl = gifUrl
        }
    }
}
