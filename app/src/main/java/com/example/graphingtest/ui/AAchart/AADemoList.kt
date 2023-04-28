package com.example.graphingtest.ui.AAchart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.graphingtest.DemoList
import com.example.graphingtest.TESTFRAGMENT
import com.example.graphingtest.databinding.DemolistBinding

class AADemoList : DemoList() {
    private lateinit var binding: DemolistBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DemolistBinding.inflate(layoutInflater)

        val items = listOf(
            DemoListItem(BarChartFragment::class.java, "bar chart"),
            DemoListItem(AreaChartFragment::class.java, "AreaChart"),
            DemoListItem(AreaRangeChartFragment::class.java, "AreaRangeChart"),
            DemoListItem(AreasplineChartFragment::class.java, "AreasplineChart"),
            DemoListItem(BoxplotChartFragment::class.java, "BoxplotChart"),
            DemoListItem(BubbleChartFragment::class.java, "BubbleChart"),
            DemoListItem(ColumnChartFragment::class.java, "ColumnChart"),
            DemoListItem(FunnelChartFragment::class.java, "FunnelChart"),
            DemoListItem(GaugeChartFragment::class.java, "GaugeChart"),
            DemoListItem(LineChartFragment::class.java, "LineChart"),
            DemoListItem(PieChartFragment::class.java, "PieChart"),
            DemoListItem(PolygonChartFragment::class.java, "PolygonChart"),
            DemoListItem(PyramidChartFragment::class.java, "PyramidChart"),
        )

        binding.gvDemolist.adapter = GridViewDemoListAdapter(items)

        return binding.root
    }
}

