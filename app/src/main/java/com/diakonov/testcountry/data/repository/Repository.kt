package com.diakonov.testcountry.data.repository

import com.diakonov.testcountry.data.api.RetrofitInstance
import com.diakonov.testcountry.model.Info
import retrofit2.Response

class Repository {

    suspend fun getCountries(): Response<Info>{
        return RetrofitInstance.api.getCountries()
    }
}