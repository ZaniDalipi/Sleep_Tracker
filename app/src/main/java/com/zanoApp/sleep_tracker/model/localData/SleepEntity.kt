package com.zanoApp.sleep_tracker.model.localData

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sleep_entity_table")
data class SleepEntity(

    @PrimaryKey(autoGenerate = true) var sleepId: Long = 0L,
    @ColumnInfo(name = "start_time")  val startTimeMilli: Long = System.currentTimeMillis(),
    @ColumnInfo(name = "end_time") var endTimeMilli: Long = startTimeMilli,
    @ColumnInfo(name = "sleep_quality") var sleepQuality: Int = -1

)