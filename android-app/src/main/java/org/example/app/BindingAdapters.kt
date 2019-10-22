/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package org.example.app

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide

@BindingAdapter("gifUrl")
fun ImageView.bindGif(gifUrl: String?) {
    if (gifUrl == null) {
        this.setImageDrawable(null)
        return
    }

    val circularProgressDrawable = CircularProgressDrawable(context).apply {
        strokeWidth = 5f
        centerRadius = 30f
        start()
    }

    Glide.with(this)
        .load(gifUrl)
        .placeholder(circularProgressDrawable)
        .error(android.R.drawable.stat_notify_error)
        .into(this)
}
