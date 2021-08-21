package com.jb.svb.contactsaver.utilities

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar

fun Context.showToast(@StringRes messageId: Int) {
    Toast.makeText(this, messageId, Toast.LENGTH_LONG).show()
}

fun View.showSnackbar(@StringRes messageId: Int) {
    Snackbar.make(this, messageId, Snackbar.LENGTH_LONG).show()
}
