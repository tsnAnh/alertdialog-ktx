package dev.tsnanh.dialogktx

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import dev.tsnanh.alertdialog.ktx.buildAlertDialog

class MainActivity : AppCompatActivity() {
    private val alertDialog by buildAlertDialog {
        title { "TEST" }
        message { "TEST" }
        positiveClick {
            label { "OK" }
            onClick {
                Snackbar.make(window.decorView, R.string.app_name, Snackbar.LENGTH_LONG).show()
            }
        }
        negativeClick {
            label { "Cancel" }
        }
        neutralClick {
            label { "Neutral" }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        alertDialog.show()
    }
}
