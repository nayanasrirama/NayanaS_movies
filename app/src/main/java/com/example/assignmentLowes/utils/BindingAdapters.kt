package com.example.assignmentLowes.utils

import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * @author Nayana S <nethragowda6@gmail.com>
 * @version 1.0, $date 2021/26/06 7:00 PM
 */
@BindingAdapter("visibleGone")
fun visibleGone(view: View, value: Boolean) {
    view.visibility = if (value) View.VISIBLE else View.GONE
}

@BindingAdapter("imageSrc")
fun imageUrl(view: ImageView, url: String?) {
    Glide.with(view.context)
            .load(url)
            .into(view)
}

@BindingAdapter("text")
fun text(view: TextView, text: String) {
    view.movementMethod = LinkMovementMethod.getInstance()
    view.text = text
}

