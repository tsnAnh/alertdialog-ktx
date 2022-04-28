package dev.tsnanh.alertdialog.ktx

import android.content.Context
import androidx.appcompat.app.AlertDialog
import dev.tsnanh.alertdialog.ktx.builders.AlertDialogKtxBuilder
import dev.tsnanh.alertdialog.ktx.delegates.AlertDialogKtxDelegate
import kotlin.properties.ReadOnlyProperty

fun Context.alertDialog(
    block: AlertDialogKtxBuilder.() -> Unit
) = AlertDialogKtxBuilder()
    .apply(block)
    .build()
    .createAlertDialog(this)

fun buildAlertDialog(
    block: AlertDialogKtxBuilder.() -> Unit
): ReadOnlyProperty<Context, AlertDialog> = AlertDialogKtxDelegate(block)
