package com.zanoApp.sleep_tracker.model.localData.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.zanoApp.sleep_tracker.model.localData.SleepDatabase
import com.zanoApp.sleep_tracker.model.localData.SleepEntity
import kotlinx.coroutines.*
import java.lang.NullPointerException

class Repository(private val sleepDatabase: SleepDatabase) {

    suspend fun getSleepNight(): SleepEntity {

        return withContext(Dispatchers.Default) {
            try {
                sleepDatabase.sleepDatabaseDao.getOneSleepNight()
            } catch (e: NullPointerException) {
                throw NullPointerException("something went wrong")
            }
        }
    }

    suspend fun getAllSleepNight(): LiveData<List<SleepEntity>> {

        return withContext(Dispatchers.Default) {
            try {
                sleepDatabase.sleepDatabaseDao.getAllSleepNights()
            } catch (e: NullPointerException) {
                throw NullPointerException("something went wrong")
            }
        }
    }

    fun insert(sleep: SleepEntity){
        sleepDatabase.sleepDatabaseDao.insert(sleep)
    }


}