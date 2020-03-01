package com.zanoApp.sleep_tracker

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.zanoApp.sleep_tracker.model.localData.SleepEntity

@BindingAdapter("sleepDurationFormatted")
fun TextView.setSleepDurationFormatted(data: SleepEntity?) {
    data?.let {
        text = convertTime(data.startTimeMilli, data.endTimeMilli, context.resources)
    }
}

@BindingAdapter("sleepQualityInfo")
fun TextView.sleepQualityInfo(data: SleepEntity?) {
    data?.let {
        TODO("create a method that will format em")
    }
}

@BindingAdapter("setImage")
fun ImageView.setImage(data: SleepEntity?) {
    data?.let {
        setImageResource(
            when (data.sleepQuality) {
                0 -> androidx.vectordrawable.R.drawable.notification_action_background
                1 -> androidx.vectordrawable.R.drawable.notification_bg
                2 -> androidx.vectordrawable.R.drawable.notification_bg_low_pressed
                3 -> androidx.vectordrawable.R.drawable.notification_template_icon_bg
                4 -> androidx.vectordrawable.R.drawable.notification_action_background
                5 -> androidx.vectordrawable.R.drawable.notification_action_background
                else -> R.drawable.ic_launcher_background
            }
        )
    }

}
