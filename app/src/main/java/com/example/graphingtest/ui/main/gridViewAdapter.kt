package com.example.graphingtest.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.graphingtest.R

data class GridViewItem(val fragmentClass: Class<out Fragment>, val name: String, val imageResource : Int)

class GridViewAdapter(private val items: List<GridViewItem>) : BaseAdapter() {

    override fun getCount() = items.size

    override fun getItem(position: Int) = items[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(parent?.context).inflate(R.layout.gv_item, parent, false)

        val item = getItem(position)

        val textView = view.findViewById<TextView>(R.id.tv_item_name)
        val imageView = view.findViewById<ImageView>(R.id.iv_item_image)
        textView.text = item.name
        imageView.setImageResource(item.imageResource)
        view.setOnClickListener {
            val fragmentManager = (view.context as AppCompatActivity).supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()

            // Create a new instance of the fragment using its default constructor
            val fragment = item.fragmentClass.newInstance()

            // Add the fragment to the container layout
            fragmentTransaction.replace(R.id.container, fragment)

            // Add the fragment to the back stack using its tag
            fragmentTransaction.addToBackStack(fragment.tag)
            fragmentTransaction.commit()
        }

        return view
    }
}


