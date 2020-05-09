package com.project.kabaadibazaar.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.project.kabaadibazaar.R
import com.project.kabaadibazaar.activity.RateListActivity
import com.project.kabaadibazaar.activity.WeBuyActivity
import com.project.kabaadibazaar.adapter.ImageAdapter
import kotlinx.android.synthetic.main.fragment_homa.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomaFragment : Fragment(), View.OnClickListener {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_homa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
    }

    private fun initView() {
        imgWebuy.setOnClickListener(this)
        imgRateList.setOnClickListener(this)
        imgReports.setOnClickListener(this)
        imgContibution.setOnClickListener(this)
        imgTrack.setOnClickListener(this)

        val images = intArrayOf(R.drawable.ic_quick_request, R.drawable.ic_refer, R.drawable.ic_track_request)
        val viewpager = requireView().findViewById(R.id.viewPager) as ViewPager

        val adapterView = ImageAdapter(requireContext(), images)
        viewpager.adapter = adapterView
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                HomaFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.imgBack -> {
                startActivity(Intent(activity, WeBuyActivity::class.java))
            }
            R.id.imgRateList -> {
                startActivity(Intent(activity, RateListActivity::class.java))
            }
            R.id.imgReports -> {

            }
            R.id.imgContibution -> {

            }
            R.id.imgTrack -> {

            }
        }
    }
}
