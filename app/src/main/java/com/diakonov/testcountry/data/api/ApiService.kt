package com.diakonov.testcountry.data.api


import com.diakonov.testcountry.model.Info
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {



    @GET( "v2/all")
    suspend fun getCountries(): Response<Info>




}

