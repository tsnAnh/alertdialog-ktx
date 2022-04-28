package dev.tsnanh.alertdialog.ktx.builders

import android.graphics.drawable.Drawable
import dev.tsnanh.alertdialog.ktx.AlertDialogKtx
import dev.tsnanh.alertdialog.ktx.DialogButtonScope
import dev.tsnanh.alertdialog.ktx.annotations.DialogKtxDslMarker

@DialogKtxDslMarker
class AlertDialogKtxBuilder {
    private var background: Drawable? = null
    private var isCancelable: Boolean = true
    private var title: String? = null
    private var message: String? = null
    private var icon: Drawable? = null
    private var dismissListener: () -> Unit = {}
    private var positiveButtonScope: DialogButtonScope? = null
    private var negativeButtonScope: DialogButtonScope? = null
    private var neutralButtonScope: DialogButtonScope? = null

    fun background(block: () -> Drawable?) {
        this.background = block()
    }

    fun isCancelable(block: () -> Boolean) {
        this.isCancelable = block()
    }

    fun title(block: () -> String) {
        this.title = block()
    }

    fun message(block: () -> String) {
        this.message = block()
    }

    fun icon(block: () -> Drawable?) {
        this.icon = block()
    }

    fun onDismiss(block: () -> Unit) {
        this.dismissListener = block
    }

    fun positiveClick(block: DialogButtonScopeBuilder.() -> Unit) {
        this.positiveButtonScope = DialogButtonScopeBuilder().apply(block).build()
    }

    fun negativeClick(block: DialogButtonScopeBuilder.() -> Unit) {
        this.negativeButtonScope = DialogButtonScopeBuilder().apply(block).build()
    }

    fun neutralClick(block: DialogButtonScopeBuilder.() -> Unit) {
        this.neutralButtonScope = DialogButtonScopeBuilder().apply(block).build()
    }

    internal fun build() = AlertDialogKtx(
        background,
        isCancelable,
        title,
        message,
        icon,
        dismissListener,
        positiveButtonScope,
        negativeButtonScope,
        neutralButtonScope
    )
}
