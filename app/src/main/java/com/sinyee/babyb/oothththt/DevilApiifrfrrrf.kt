package com.sinyee.babyb.oothththt

import retrofit2.Response
import retrofit2.http.GET

interface DevilApiifrfrrrf {

    @GET("json/?key=KXgMIA7HSEcn0SV")
    suspend fun getData(): Response<CountryCodeJS>

    @GET("const.json")
    suspend fun getDataDev(): Response<GeoDev>
}




