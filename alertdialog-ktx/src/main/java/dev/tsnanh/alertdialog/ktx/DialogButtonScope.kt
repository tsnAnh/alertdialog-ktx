package dev.tsnanh.alertdialog.ktx

import android.content.DialogInterface
import android.graphics.drawable.Drawable

data class DialogButtonScope(
    val label: String = "",
    val icon: Drawable? = null,
    val onClick: DialogInterface.(which: Int) -> Unit = {},
)
