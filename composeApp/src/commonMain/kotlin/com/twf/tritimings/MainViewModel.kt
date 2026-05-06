package com.twf.tritimings

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.twf.tritimings.domain.CalculateTimeUseCase
import com.twf.tritimings.domain.Distance
import com.twf.tritimings.domain.Sport
import com.twf.tritimings.domain.Unit

class MainViewModel(private val calculateTimeUseCase: CalculateTimeUseCase = CalculateTimeUseCase()): ViewModel() {
    val runState = TextFieldState()
    val swimState = TextFieldState()
    val bikeState = TextFieldState()
    val t1state = TextFieldState()
    val t2state = TextFieldState()

    var isMetric by mutableStateOf(false)
        private set

    fun toggleMetric(metric: Boolean) {
        isMetric = metric
    }

    var distance by mutableStateOf("Sprint")
        private set

    fun updateDistance(setDistance: String) {
        distance = setDistance
    }

    private fun parseTimeToSeconds(input: String): Double? {
        val trimmed = input.trim()
        if (trimmed.isEmpty()) return null

        if (trimmed.contains(":")) {
            val parts = trimmed.split(":")
            if (parts.size == 2) {
                val m = parts[0].toDoubleOrNull() ?: 0.0
                val s = parts[1].toDoubleOrNull() ?: 0.0
                return m * 60 + s
            }
        }

        if (trimmed.all { it.isDigit() } && trimmed.length >= 3) {
            val s = trimmed.takeLast(2).toDoubleOrNull() ?: 0.0
            val m = trimmed.dropLast(2).toDoubleOrNull() ?: 0.0
            return m * 60 + s
        }

        if (trimmed.contains(".")) {
            val parts = trimmed.split(".")
            if (parts.size == 2) {
                val m = parts[0].toDoubleOrNull() ?: 0.0
                val sStr = parts[1]
                val s = when (sStr.length) {
                    0 -> 0.0
                    1 -> (sStr.toDoubleOrNull() ?: 0.0) * 10
                    else -> sStr.take(2).toDoubleOrNull() ?: 0.0
                }
                return m * 60 + s
            }
        }

        return trimmed.toDoubleOrNull()
    }

    val totalValue by derivedStateOf {
        val swimPace = parseTimeToSeconds(swimState.text.toString())
        val bikeSpeed = bikeState.text.toString().toDoubleOrNull()
        val runPace = parseTimeToSeconds(runState.text.toString())
        
        val t1val = parseTimeToSeconds(t1state.text.toString()) ?: 0.0
        val t2val = parseTimeToSeconds(t2state.text.toString()) ?: 0.0

        val distanceDomain = convertDistance(distance)
        val unit = if(isMetric) Unit.Metric else Unit.Imperial

        val swimTime = calculateTimeUseCase(unit, Sport.Swim, distanceDomain, swimPace)
        val bikeTime = calculateTimeUseCase(unit, Sport.Bike, distanceDomain, bikeSpeed)
        val runTime = calculateTimeUseCase(unit, Sport.Run, distanceDomain, runPace)

        if (swimTime == null || bikeTime == null || runTime == null) { 
            return@derivedStateOf null
        }
        
        (swimTime + bikeTime + runTime + t1val + t2val).toPaceString()
    }

    fun convertDistance(distance: String): Distance {
        return when(distance) {
            "Sprint" -> Distance.Sprint
            "Olympic" -> Distance.Olympic
            "70.3" -> Distance.HalfIron
            "Iron" -> Distance.Iron
            else -> Distance.Sprint
        }
    }

    fun Double.toPaceString(): String {
        if (this.isInfinite() || this.isNaN()) return "--:--:--"
        
        val totalSeconds = this.toInt()
        val h = totalSeconds / 3600
        val m = (totalSeconds % 3600) / 60
        val s = totalSeconds % 60

        return if (h > 0) {
            "$h:${m.toString().padStart(2, '0')}:${s.toString().padStart(2, '0')}"
        } else {
            "$m:${s.toString().padStart(2, '0')}"
        }
    }
}
