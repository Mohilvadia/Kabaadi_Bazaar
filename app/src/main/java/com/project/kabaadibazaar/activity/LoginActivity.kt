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
import com.project.kabaadibazaar.Preference
import com.project.kabaadibazaar.R
import com.project.kabaadibazaar.extension.hideProgressDialog
import com.project.kabaadibazaar.extension.showProgressDialog
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()
        initView()
    }

    private fun initView() {
        imgBack.setOnClickListener(this)
        btnLogin.setOnClickListener(this)
        tvForgotPassword.setOnClickListener(this)
        tvSignUp.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnLogin -> {
                if (isValid()) {
                    loginUser()
                }
            }
            R.id.tvSignUp -> {
                startActivity(Intent(this, SignUpActivity::class.java))
            }
            R.id.tvForgotPassword -> {
                startActivity(Intent(this, ForgotPasswordActivity::class.java))
            }
            R.id.imgBack -> onBackPressed()
        }
    }

    private fun loginUser() {
        showProgressDialog()
        val email: String = etEmail.text.toString()
        val password: String = etPassword.text.toString()

        mAuth!!.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(object : OnCompleteListener<AuthResult> {
                    override fun onComplete(task: Task<AuthResult>) {
                        if (task.isSuccessful) {
                            hideProgressDialog()
                            Preference.getInstance().isLogin = true
                            Toast.makeText(applicationContext, "Login successful!", Toast.LENGTH_LONG).show()
                            val intent = Intent(this@LoginActivity, DashBoardActivity::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(applicationContext, "Login failed! Please try again later", Toast.LENGTH_LONG).show()
                            hideProgressDialog()
                        }
                    }

                })
    }

    private fun isValid(): Boolean {
        if (TextUtils.isEmpty(etEmail.text.toString())) {
            Toast.makeText(this, "please enter email address", Toast.LENGTH_SHORT).show()
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
        return true
    }

    private fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}