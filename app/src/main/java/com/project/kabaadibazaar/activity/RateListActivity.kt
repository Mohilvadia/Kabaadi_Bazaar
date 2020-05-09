package com.project.kabaadibazaar.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.project.kabaadibazaar.R
import kotlinx.android.synthetic.main.activity_rate_list.*
import kotlinx.android.synthetic.main.city_dialog.view.*


class RateListActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_list)

        initView()
    }

    private fun initView() {
        imgBack.setOnClickListener(this)
        imgMenu.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.imgBack -> {
                onBackPressed()
            }
            R.id.imgMenu -> {
                openDialog()
            }
        }
    }

    private fun openDialog() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.city_dialog, null)
        val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("")
        val mAlertDialog = mBuilder.show()
        mDialogView.tvBhopal.setOnClickListener {
            mAlertDialog.dismiss()
            tvCity.text = getString(R.string.bhopal_)
        }
        mDialogView.tvAbd.setOnClickListener {
            mAlertDialog.dismiss()
            tvCity.text = getString(R.string.abd)
        }
        mDialogView.tvAurangabad.setOnClickListener {
            mAlertDialog.dismiss()
            tvCity.text = getString(R.string.aur)
        }
        mDialogView.tvRaipur.setOnClickListener {
            mAlertDialog.dismiss()
            tvCity.text = getString(R.string.raipur_)
        }
        mDialogView.tvIndore.setOnClickListener {
            mAlertDialog.dismiss()
            tvCity.text = getString(R.string.indore_)
        }
    }

}
