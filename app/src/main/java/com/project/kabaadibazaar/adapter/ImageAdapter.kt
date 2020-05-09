package com.project.kabaadibazaar.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter
import com.project.kabaadibazaar.R


class ImageAdapter(var context: Context, var images: IntArray) : PagerAdapter() {
    var layoutInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView: View = layoutInflater.inflate(R.layout.item_viewpager, container, false)
        val imageView = itemView.findViewById<View>(R.id.img) as ImageView
        imageView.setImageResource(images[position])
        container.addView(itemView)

        imageView.setOnClickListener { Toast.makeText(context, "you clicked image " + (position + 1), Toast.LENGTH_LONG).show() }
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }

}