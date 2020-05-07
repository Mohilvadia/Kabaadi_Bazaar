package com.project.kabaadibazaar.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.project.kabaadibazaar.Const
import com.project.kabaadibazaar.Preference
import com.project.kabaadibazaar.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        Handler().postDelayed({
            moveToNextScreen()
        }, Const.DELAY_MILLIS)
    }

    private fun moveToNextScreen() {
        if (Preference.getInstance().isLogin) {
            startActivity(Intent(this, DashBoardActivity::class.java))
            finish()
        } else {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}
