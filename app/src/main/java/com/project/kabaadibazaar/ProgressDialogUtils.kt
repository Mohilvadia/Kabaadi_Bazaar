package com.project.kabaadibazaar

import android.app.Activity
import android.app.ProgressDialog

class ProgressDialogUtils {
    var progressDialog: ProgressDialog? = null

    companion object {
        private var instance: ProgressDialogUtils? = null

        fun getInstance(): ProgressDialogUtils {
            if (instance == null) {
                instance = ProgressDialogUtils()
            }
            return instance as ProgressDialogUtils
        }
    }

    fun create(activity: Activity): ProgressDialogUtils {
        progressDialog = ProgressDialog(activity)
        progressDialog!!.setMessage("Loading...")
        return this
    }

    fun cancelable(isCancelable: Boolean): ProgressDialogUtils {
        if (progressDialog != null) {
            progressDialog?.setCancelable(isCancelable)
        }
        return this
    }

    fun show() {
        progressDialog?.show()
    }

    fun hide() {
        progressDialog?.dismiss()
    }

}