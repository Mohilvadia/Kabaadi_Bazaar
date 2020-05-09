package com.project.kabaadibazaar.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import com.project.kabaadibazaar.R
import com.project.kabaadibazaar.adapter.RequestAdapter
import kotlinx.android.synthetic.main.fragment_request.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class RequestFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_request, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
    }

    private fun initView() {
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#62cb31"));
        tabLayout.setSelectedTabIndicatorHeight((2 * resources.displayMetrics.density).toInt())
        tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#62cb31"));
        tabLayout.addTab(tabLayout.newTab().setText("PENDING"))
        tabLayout.addTab(tabLayout.newTab().setText("COMPLETED"))
        tabLayout.addTab(tabLayout.newTab().setText("CANCELLED"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = RequestAdapter(childFragmentManager, tabLayout.tabCount)
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                RequestFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
