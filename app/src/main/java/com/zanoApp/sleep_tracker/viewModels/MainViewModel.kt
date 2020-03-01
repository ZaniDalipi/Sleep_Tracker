package com.zanoApp.sleep_tracker.viewModels

import android.app.Application
import androidx.lifecycle.*
import com.zanoApp.sleep_tracker.model.localData.SleepDatabase
import com.zanoApp.sleep_tracker.model.localData.SleepEntity
import com.zanoApp.sleep_tracker.model.localData.repo.Repository
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.io.IOException
import java.lang.RuntimeException
import javax.sql.DataSource

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val job = Job()
    private val repository = Repository(SleepDatabase.getInstance(application))

    private var _oneNightOfSleep = MutableLiveData<SleepEntity>()
    private val oneNightOfSleep: LiveData<SleepEntity> get() = _oneNightOfSleep

    private var _sleepingData = MutableLiveData<LiveData<List<SleepEntity>>>()
    val sleepingData: MutableLiveData<LiveData<List<SleepEntity>>> get() = _sleepingData

    fun getOneNightOfSleep() {
        viewModelScope.launch {
            _oneNightOfSleep.value = repository.getSleepNight()
        }
    }

    fun getAllNights() {
        viewModelScope.launch {
            _sleepingData.value = repository.getAllSleepNight()
        }
    }

    fun insertTheNight() {
        viewModelScope.launch {
            repository.insert(_oneNightOfSleep.value!!)
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel("the jobs have been canceled following the destroying of the viewModel")
    }
}
