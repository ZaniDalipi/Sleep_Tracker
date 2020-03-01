package com.zanoApp.sleep_tracker

import android.content.res.Resources
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

private val ONE_MINUTE = TimeUnit.SECONDS.convert(1, TimeUnit.MINUTES)
private val ONE_HOUR = TimeUnit.SECONDS.convert(1, TimeUnit.HOURS)


fun convertTime(startMillis: Long, endMillis: Long, res: Resources): String {

    val durationOfSleep = startMillis - endMillis
    val weekDayStringFormat = SimpleDateFormat("EEEE", Locale.getDefault()).format(startMillis)
    return when {
        durationOfSleep < ONE_MINUTE -> {
            val seconds = TimeUnit.MINUTES.convert(durationOfSleep, TimeUnit.SECONDS)
            res.getString(R.string.seconds_length, seconds, weekDayStringFormat)
        }
        durationOfSleep < ONE_HOUR -> {
            val minutes = TimeUnit.MINUTES.convert(durationOfSleep, TimeUnit.SECONDS)
            res.getString(R.string.minutes_length, minutes, weekDayStringFormat)
        }
        else -> {
            val hours = TimeUnit.HOURS.convert(durationOfSleep, TimeUnit.SECONDS)
            res.getString(R.string.hours_length, hours, weekDayStringFormat)
        }
    }

}