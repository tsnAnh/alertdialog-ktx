# alertdialog-ktx
Kotlin DSL wrapper for Android AlertDialog

## Basic Usage
```kotlin
alertDialog {
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
```

## or create class level property by using `buildAlertDialog`
```kotlin
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
```
