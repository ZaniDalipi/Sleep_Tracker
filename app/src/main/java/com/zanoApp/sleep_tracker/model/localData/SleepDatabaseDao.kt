package com.zanoApp.sleep_tracker.model.localData

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface SleepDatabaseDao {

    @Insert
    fun insert(sleep: SleepEntity)

    @Update
    fun update(sleep: SleepEntity)

    @Query("SELECT * FROM sleep_entity_table WHERE  sleepId = :key")
    fun get(key : Long): SleepEntity
    
    @Query("DELETE FROM sleep_entity_table")
    fun deleteAll()
    
    @Query("SELECT * FROM sleep_entity_table")
    fun getOneSleepNight(): SleepEntity
    
    @Query("SELECT * FROM sleep_entity_table ORDER BY sleepId DESC")
    fun getAllSleepNights(): LiveData<List<SleepEntity>>
}