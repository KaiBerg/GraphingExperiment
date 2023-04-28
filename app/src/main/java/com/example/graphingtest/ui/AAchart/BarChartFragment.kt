package com.example.graphingtest.ui.AAchart

import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.graphingtest.Data.Repo
import com.example.graphingtest.R
import com.example.graphingtest.databinding.AaChartViewBinding
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartZoomType
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAXAxis

class BarChartFragment : Fragment(R.layout.aa_chart_view) {
    private lateinit var binding: AaChartViewBinding
    private var data = Repo.Measurements
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = AaChartViewBinding.inflate(layoutInflater)


        val b22 = data.map { it.b22 }.take(1300).toTypedArray<Any>()
        val b31 = data.map { it.b31 }.take(1300).toTypedArray<Any>()
        val b32 = data.map { it.b32 }.take(1300).toTypedArray<Any>()
        val dates = data.map { it.logTime.toString() }.take(1300).toTypedArray()

        d("aachart", "${b22.size}, ${b31.size}, ${b32.size}")
        val aaChartModel : AAChartModel = AAChartModel()
            .chartType(AAChartType.Area)
            .dataLabelsEnabled(false)
//            .xAxisTickInterval(300)
            .yAxisMax(160)
            .yAxisMin(18.5)
            .title("Pressure Test")
            .categories(dates)
            .series(arrayOf(
                AASeriesElement()
                    .name("b22")
                    .data(b22),
                AASeriesElement()
                    .name("b31")
                    .data(b31),
                AASeriesElement()
                    .name("b32")
                    .data(b32)
            ))

        binding.aacv.aa_drawChartWithChartModel(aaChartModel)
        return binding.root
    }
}