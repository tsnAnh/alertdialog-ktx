package dev.tsnanh.alertdialog.ktx

import android.content.Context
import android.content.DialogInterface
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.BaseAdapter
import android.widget.ListAdapter
import androidx.annotation.AttrRes
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dev.tsnanh.alertdialog.ktx.models.BackgroundInsetValues

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
    val backgroundInsetValues: BackgroundInsetValues = BackgroundInsetValues(),
    val adapter: ListAdapter? = null,
    val onItemClickListener: ((dialog: DialogInterface, which: Int) -> Unit)? = null,
    val customTitle: View? = null,
    @AttrRes val iconAttribute: Int? = null,
    val onCancelListener: ((DialogInterface) -> Unit)? = null,
)

fun AlertDialogKtx.createAlertDialog(ctx: Context) = with(this) {
    assert(adapter != null && onItemClickListener != null) {
        "Hehe"
    }
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
        .setBackgroundInsetStart(backgroundInsetValues.start)
        .setBackgroundInsetEnd(backgroundInsetValues.end)
        .setBackgroundInsetTop(backgroundInsetValues.top)
        .setBackgroundInsetBottom(backgroundInsetValues.bottom)
        .setAdapter(adapter) { d, w ->
            onItemClickListener?.invoke(d, w)
        }
        .setCustomTitle(customTitle)
        .setOnCancelListener { d ->
            onCancelListener?.invoke(d)
        }
        .apply {
            this@with.background?.let {
                this.background = it
            }
            this@with.iconAttribute?.let {
                setIconAttribute(iconAttribute)
            }
        }
        .create()
}
