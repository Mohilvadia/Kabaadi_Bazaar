package com.project.kabaadibazaar.extension

import androidx.appcompat.app.AppCompatActivity
import com.project.kabaadibazaar.ProgressDialogUtils


fun AppCompatActivity.showProgressDialog() {
    ProgressDialogUtils.getInstance()
            .create(this)
            .cancelable(false)
            .show()
}

fun AppCompatActivity.hideProgressDialog() {
    ProgressDialogUtils.getInstance()
            .hide()
}
