package com.example.graphingtest.ui.anychart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anychart.AnyChart;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.example.graphingtest.Data.Repo
import com.example.graphingtest.R
import com.example.graphingtest.databinding.AnyChartViewBinding

class AnyBarChartFragment : Fragment(R.layout.aa_chart_view) {
    private lateinit var binding: AnyChartViewBinding
    private var data = Repo.Measurements
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = AnyChartViewBinding.inflate(layoutInflater)



        val b22 = Repo.Measurements.take(1300).map { value ->
            ValueDataEntry(value.logTime.toString(), value.b22)
        }

        val b31 = Repo.Measurements.take(1300).map { value ->
            ValueDataEntry(value.logTime.toString(), value.b31)
        }

        val b32 = Repo.Measurements.take(1300).map { value ->
            ValueDataEntry(value.logTime.toString(), value.b32)
        }

        val barChart = AnyChart.column()

        barChart.column(b22)
        barChart.column(b31)
        barChart.column(b32)
        barChart.title("Pressure Test")

        barChart.xAxis(0).title("Time")
        barChart.yAxis(0).title("Pressure")

        binding.cvAny.setChart(barChart)
        return binding.root
    }

}
