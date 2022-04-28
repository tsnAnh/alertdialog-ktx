package dev.tsnanh.alertdialog.ktx

import android.content.Context
import android.graphics.drawable.Drawable
import com.google.android.material.dialog.MaterialAlertDialogBuilder

data class AlertDialogKtx(
    val background: Drawable? = null,
    val isCancelable: Boolean = true,
    val title: String?,
    val message: String?,
    val icon: Drawable? = null,
    val dismissListener: () -> Unit = {},
    val positiveButtonScope: DialogButtonScope? = null,
    val negativeButtonScope: DialogButtonScope? = null,
    val neutralButtonScope: DialogButtonScope? = null,
)

fun AlertDialogKtx.createAlertDialog(ctx: Context) = with(this) {
    MaterialAlertDialogBuilder(ctx)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton(positiveButtonScope?.label) { d, w ->
            positiveButtonScope?.onClick?.invoke(d, w)
        }
        .setPositiveButtonIcon(positiveButtonScope?.icon)
        .setNegativeButton(negativeButtonScope?.label) { d, w ->
            negativeButtonScope?.onClick?.invoke(d, w)
        }
        .setNegativeButtonIcon(negativeButtonScope?.icon)
        .setNeutralButton(neutralButtonScope?.label) { d, w ->
            neutralButtonScope?.onClick?.invoke(d, w)
        }
        .setNeutralButtonIcon(neutralButtonScope?.icon)
        .apply {
            this@with.background?.let {
                this.background = it
            }
        }
        .create()
}
