package com.project.kabaadibazaar.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.project.kabaadibazaar.R
import com.project.kabaadibazaar.extension.hideProgressDialog
import com.project.kabaadibazaar.extension.showProgressDialog
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity(), View.OnClickListener {

    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        mAuth = FirebaseAuth.getInstance()
        initView()
    }

    private fun initView() {
        imgBack.setOnClickListener(this)
        btnRegister.setOnClickListener(this)
        tvMoveToLogin.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnRegister -> {
                if (isValid()) {
                    registerUser()
                }
            }
            R.id.tvMoveToLogin -> {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
            R.id.imgBack -> {
                onBackPressed()
            }
        }
    }

    private fun registerUser() {
        showProgressDialog()
        val email: String = etEmail.text.toString()
        val password: String = etPassword.text.toString()

        mAuth!!.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(object : OnCompleteListener<AuthResult> {
                    override fun onComplete(task: Task<AuthResult>) {
                        if (task.isSuccessful) {
                            hideProgressDialog()
                            Toast.makeText(applicationContext, "Registration successful!", Toast.LENGTH_LONG).show()
                            startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
                            finish()
                        } else {
                            Toast.makeText(applicationContext, "Registration failed! Please try again later", Toast.LENGTH_LONG).show()
                            hideProgressDialog()
                        }
                    }

                })
    }

    private fun isValid(): Boolean {
        if (TextUtils.isEmpty(etName.text.toString())) {
            Toast.makeText(this, "please enter name", Toast.LENGTH_SHORT).show()
            return false
        }
        if (TextUtils.isEmpty(etEmail.text.toString())) {
            Toast.makeText(this, "please enter email", Toast.LENGTH_SHORT).show()
            return false
        }
        if (!isEmailValid(etEmail.text.toString().trim())) {
            Toast.makeText(this, "please enter valid email", Toast.LENGTH_SHORT).show()
            return false
        }
        if (TextUtils.isEmpty(etPassword.text.toString())) {
            Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show()
            return false
        }
        if (etPassword.text.toString() != etConfirmPassword.text.toString()) {
            Toast.makeText(this, "Password and Confirm Password Does not match", Toast.LENGTH_SHORT).show()
            return false
        }
        if (etPassword.text.toString().length < 6) {
            Toast.makeText(this, "Password have at at least 6 character long and mix of letters and number", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }

    private fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
