package com.example.graphingtest.ui.vico

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.graphingtest.Data.Repo
import com.example.graphingtest.R
import com.example.graphingtest.databinding.VicoChartViewBinding
import com.github.mikephil.charting.renderer.AxisRenderer
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.core.axis.AxisPosition
import com.patrykandpatrick.vico.core.axis.horizontal.HorizontalAxis
import com.patrykandpatrick.vico.core.chart.line.LineChart
import com.patrykandpatrick.vico.core.chart.scale.AutoScaleUp
import com.patrykandpatrick.vico.core.entry.entryModelOf
import com.patrykandpatrick.vico.views.scroll.ChartScrollSpec

class VicoChartFragment : Fragment(R.layout.aa_chart_view) {
    private lateinit var binding: VicoChartViewBinding
    private var data = Repo.Measurements
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = VicoChartViewBinding.inflate(layoutInflater)

        val b22 = data.map { it.b22 }.take(1300)
        val b31 = data.map { it.b31 as Number }.toTypedArray().take(1300)
        val b32 = data.map { it.b32 }.take(1300)
        val chartEntryModel = entryModelOf(*b22.toTypedArray())
        binding.cvVico
        val spec = binding.cvVico.chartScrollSpec
        binding.cvVico.setModel(chartEntryModel)


        return binding.root
    }
}