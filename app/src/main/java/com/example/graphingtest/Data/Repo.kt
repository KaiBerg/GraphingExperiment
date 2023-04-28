package com.example.graphingtest.Data

import android.content.Context
import android.util.Log.d
import java.util.Date

data class Measurement(val logTime : Date, val stepNo : Long, val b31 : Double, val b32 : Double, val b22 : Double)

object Repo {
    val Measurements = ArrayList<Measurement>()

    fun setData(context: Context) {
        Measurements.addAll(CsvReader.readFilesAsMeasurement(context))
        d("NOLEKCSVDATALOG", "${Measurements.count()} read from CSV files ${Measurements[1304]}")
    }
}