package com.diakonov.testcountry.screens.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diakonov.testcountry.Event
import com.diakonov.testcountry.data.repository.Repository
import com.diakonov.testcountry.model.Info
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import retrofit2.Response

class MainInfoViewModel : ViewModel() {

    var repo = Repository()
    val countryList: MutableLiveData<Response<Info>> = MutableLiveData()
    private val statusMessage = MutableLiveData<Event<String>>()

    val message : LiveData<Event<String>>
        get() = statusMessage

    val handler = CoroutineExceptionHandler { _, exception ->
        Log.d("Network", "Caught $exception")
        statusMessage.value = Event("CONNECTION ERROR")


    }

    fun getCountries(){
        viewModelScope.launch(handler) {
            countryList.value = repo.getCountries()
        }
    }



}