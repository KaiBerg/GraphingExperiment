package com.example.graphingtest.ui.AAchart

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.graphingtest.Data.Repo
import com.example.graphingtest.R
import com.example.graphingtest.databinding.AaChartViewBinding
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement

class PieChartFragment : Fragment(R.layout.aa_chart_view) {
    private lateinit var binding: AaChartViewBinding
    private var data = Repo.Measurements
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = AaChartViewBinding.inflate(layoutInflater)


        val b22 = data.map { it.b22 }.take(data.size-100).toTypedArray<Any>()
        val b31 = data.map { it.b31 }.take(data.size-100).toTypedArray<Any>()
        val b32 = data.map { it.b32 }.take(data.size-100).toTypedArray<Any>()

        Log.d("aachart", "${b22.size}, ${b31.size}, ${b32.size}")
        val aaChartModel : AAChartModel = AAChartModel()
            .chartType(AAChartType.Pie)
            .title("title")
            .subtitle("subtitle")
            .dataLabelsEnabled(true)
            .series(arrayOf(
                AASeriesElement()
                    .name("b22")
                    .data(b22),
                AASeriesElement()
                    .name("b31")
                    .data(b31),
                AASeriesElement()
                    .name("b32")
                    .data(b32),
            ))

        binding.aacv.aa_drawChartWithChartModel(aaChartModel)


        return binding.root
    }
}