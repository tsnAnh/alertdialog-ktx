package dev.tsnanh.alertdialog.ktx.delegates

import android.content.Context
import androidx.appcompat.app.AlertDialog
import dev.tsnanh.alertdialog.ktx.alertDialog
import dev.tsnanh.alertdialog.ktx.builders.AlertDialogKtxBuilder
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

internal class AlertDialogKtxDelegate(
    private val alertDialogKtxBuilder: AlertDialogKtxBuilder.() -> Unit
) : ReadOnlyProperty<Context, AlertDialog> {
    override fun getValue(thisRef: Context, property: KProperty<*>): AlertDialog {
        return thisRef.alertDialog { apply(alertDialogKtxBuilder) }
    }
}
