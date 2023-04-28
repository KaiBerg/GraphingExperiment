package com.example.graphingtest.Data

import android.content.Context
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CsvReader {
    companion object {
        private fun checkIfMinusOne(vararg values: Int) : Boolean = values.any { it == -1 }

        @JvmStatic
        fun readFilesAsMeasurement(context: Context): ArrayList<Measurement> {
            val dateFormat = SimpleDateFormat("dd/MM/yyyy HH.mm.ss")
            var numberFormat = NumberFormat.getNumberInstance(Locale.GERMAN)
            val measurements = arrayListOf<Measurement>()

            val assets = context.assets
            assets.list("")?.forEach { fileName ->
                if (fileName.matches(".*\\.csv".toRegex())) {
                    assets.open(fileName).bufferedReader().use { reader ->
                        var logTimeIndex = -1
                        var stepNoIndex = -1
                        var b31Index = -1
                        var b32Index = -1
                        var b22Index = -1
                        for(i in 1..10) {
                            val line = reader.readLine()
                            val columns = line.split(";")
                            logTimeIndex = columns.indexOf("Log Time")
                            stepNoIndex = columns.indexOf("StepNo")
                            b31Index = columns.indexOf("B31")
                            b32Index = columns.indexOf("B32")
                            b22Index = columns.indexOf("B22")

                            if (!checkIfMinusOne(logTimeIndex, stepNoIndex, b31Index, b32Index, b22Index))
                                break
                        }

                        if (checkIfMinusOne(logTimeIndex, stepNoIndex, b31Index, b32Index, b22Index))
                            // continue
                            return@forEach

                        var lineNullable: String? = ""
                        while (reader.readLine().also { lineNullable = it } != null) {
                            val line = lineNullable!!
                            if(line.isEmpty())
                                continue
                            val columns = line.split(";")

                            val logTime = dateFormat.parse(columns[logTimeIndex])
                            val stepNo = columns[stepNoIndex].toLong()
                            val b31 = numberFormat.parse(columns[b31Index]).toDouble()
                            val b32 = numberFormat.parse(columns[b32Index]).toDouble()
                            val b22 = numberFormat.parse(columns[b22Index]).toDouble()
                            measurements.add(Measurement(logTime, stepNo, b31, b32, b22))
                        }
                        reader.close()
                    }
                }
            }

            return measurements
        }
    }
}
