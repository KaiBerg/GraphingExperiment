package com.example.graphingtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.graphingtest.databinding.CatalogBinding
import com.example.graphingtest.databinding.DemolistBinding
import com.example.graphingtest.ui.main.GridViewAdapter
import com.example.graphingtest.ui.main.GridViewItem

open class DemoList : Fragment(R.layout.demolist) {
    private lateinit var binding: DemolistBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DemolistBinding.inflate(layoutInflater)

        val items = listOf(
            DemoListItem(TESTFRAGMENT::class.java, "TestFRAGMENT"),
            DemoListItem(TESTFRAGMENT::class.java, "TestFRAGMENT"),
            DemoListItem(TESTFRAGMENT::class.java, "TestFRAGMENT"),
            DemoListItem(TESTFRAGMENT::class.java, "TestFRAGMENT"),
            DemoListItem(TESTFRAGMENT::class.java, "TestFRAGMENT"),
            DemoListItem(TESTFRAGMENT::class.java, "TestFRAGMENT"),
            )

        binding.gvDemolist.adapter = GridViewDemoListAdapter(items)

        return binding.root
    }

    data class DemoListItem(val fragment: Class<out Fragment>, val name: String)
    class GridViewDemoListAdapter(val items: List<DemoListItem>) : BaseAdapter() {
        override fun getCount() = items.size

        override fun getItem(position: Int) = items[position]

        override fun getItemId(position: Int) = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val view = convertView ?: LayoutInflater.from(parent?.context).inflate(R.layout.demolist_item, parent, false)

            val item = getItem(position)

            val textView = view.findViewById<TextView>(R.id.tv_demo_item)
            textView.text = item.name
            view.setOnClickListener {
                val fragmentManager = (view.context as AppCompatActivity).supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()

                // Create a new instance of the fragment using its default constructor
                val fragment = item.fragment.newInstance()

                // Add the fragment to the container layout
                fragmentTransaction.replace(R.id.container, fragment)

                // Add the fragment to the back stack using its tag
                fragmentTransaction.addToBackStack(fragment.tag)
                fragmentTransaction.commit()
            }

            return view
        }
    }
}