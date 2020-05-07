package com.project.kabaadibazaar.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.project.kabaadibazaar.R
import com.project.kabaadibazaar.extension.hideProgressDialog
import com.project.kabaadibazaar.extension.showProgressDialog
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPasswordActivity : AppCompatActivity(), View.OnClickListener {

    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        mAuth = FirebaseAuth.getInstance()
        initView()
    }

    private fun initView() {
        imgBack.setOnClickListener(this)
        btnSendMail.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnSendMail -> {
                if (isValid()) {
                    forgotPassword()
                }
            }
            R.id.imgBack -> onBackPressed()
        }
    }

    private fun forgotPassword() {
        showProgressDialog()
        val email = etEmail.text.toString()

        mAuth!!.sendPasswordResetEmail(email)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        hideProgressDialog()
                        Toast.makeText(applicationContext, "Reset password link has been sent to your email address.", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, LoginActivity::class.java))
                        finish()
                    }
                }
                .addOnFailureListener { exception: Exception ->
                    Toast.makeText(applicationContext, exception.message.toString(), Toast.LENGTH_SHORT).show()
                    hideProgressDialog()
                }

    }

    private fun isValid(): Boolean {
        if (TextUtils.isEmpty(etEmail.text.toString())) {
            Toast.makeText(this, "please enter email", Toast.LENGTH_SHORT).show()
            return false
        }
        if (!isEmailValid(etEmail.text.toString().trim())) {
            Toast.makeText(this, "please enter valid email", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}
