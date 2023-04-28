package com.example.graphingtest.ui.MPA

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.graphingtest.DemoList
import com.example.graphingtest.TESTFRAGMENT
import com.example.graphingtest.databinding.DemolistBinding

class MPADemoList : DemoList() {
    private lateinit var binding: DemolistBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DemolistBinding.inflate(layoutInflater)

        val items = listOf(
            DemoListItem(MPABarChartFragment::class.java, "mpaBar"),
        )

        binding.gvDemolist.adapter = GridViewDemoListAdapter(items)

        return binding.root
    }
}