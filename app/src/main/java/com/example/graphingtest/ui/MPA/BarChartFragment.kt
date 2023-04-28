package com.example.graphingtest.ui.MPA

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.graphingtest.Data.Repo
import com.example.graphingtest.R
import com.example.graphingtest.databinding.MpaBarChartBinding
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import com.github.mikephil.charting.formatter.ValueFormatter
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class MPABarChartFragment : Fragment(R.layout.aa_chart_view) {
    private lateinit var binding: MpaBarChartBinding
    private var data = Repo.Measurements
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = MpaBarChartBinding.inflate(layoutInflater)

        val b22 = data.take(1300).mapIndexed { id, it -> BarEntry(id.toFloat(), it.b22.toFloat()) }
        val b32 = data.take(1300).mapIndexed { id, it ->BarEntry(id.toFloat(), it.b32.toFloat()) }
        val b31 = data.take(1300).mapIndexed { id, it -> BarEntry(id.toFloat(), it.b31.toFloat()) }
        val b22Set = BarDataSet(b22, "b22").also { it.color = Color.BLUE }
        val b31Set = BarDataSet(b31, "b31").also { it.color = Color.GREEN }
        val b32Set = BarDataSet(b32, "b32").also { it.color = Color.RED }

        binding.mpaBcv.data = BarData(b22Set, b31Set, b32Set)
        binding.mpaBcv.xAxis.position = XAxis.XAxisPosition.BOTTOM
        binding.mpaBcv.xAxis.valueFormatter = object : ValueFormatter() {
            private val dateFormat = SimpleDateFormat("dd/MM/yyyy HH.mm.ss")
            override fun getFormattedValue(value: Float): String {
                val date = Repo.Measurements[value.toInt()].logTime
                return dateFormat.format(date)
            }
        }
        binding.mpaBcv.animateY(1000)

        binding.mpaBcv.invalidate()
        return binding.root
    }
}

