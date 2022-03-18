package com.example.consigneetransoapp.network

import com.example.consigneetransoapp.model.ConsigneeDataRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ConsigneeApi {
    @Headers("Content-Type: application/json")
    @POST("55114294")
    fun getConsigneeData(@Body UserModelRequest: ConsigneeDataRequest): Call<ConsigneeDataRequest>

}