package dev.tsnanh.alertdialog.ktx.builders

import android.content.DialogInterface
import android.graphics.drawable.Drawable
import dev.tsnanh.alertdialog.ktx.DialogButtonScope
import dev.tsnanh.alertdialog.ktx.annotations.DialogKtxDslMarker

@DialogKtxDslMarker
class DialogButtonScopeBuilder {
    private var label: String = ""
    private var icon: Drawable? = null
    private var onClick: DialogInterface.(which: Int) -> Unit = { dismiss() }

    fun label(block: () -> String) {
        this.label = block()
    }

    fun icon(block: () -> Drawable?) {
        this.icon = block()
    }

    fun onClick(onClick: DialogInterface.(which: Int) -> Unit) {
        this.onClick = onClick
    }

    internal fun build() = DialogButtonScope(label, icon, onClick)
}
