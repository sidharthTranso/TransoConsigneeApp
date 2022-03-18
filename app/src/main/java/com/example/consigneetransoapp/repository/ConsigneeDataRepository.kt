package com.example.consigneetransoapp.repository

import com.example.consigneetransoapp.model.ConsigneeDataRequest
import com.example.consigneetransoapp.model.ConsigneeDataResponse
import com.example.consigneetransoapp.network.ConsigneeApi
import com.example.consigneetransoapp.network.ServiceBuilder

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ConsigneeDataRepository {
    fun getConsigneeData(consigneeDataRequest: ConsigneeDataRequest, onResult:(ConsigneeDataResponse?) -> Unit) {
        val retrofit = ServiceBuilder.buildService((ConsigneeApi::class.java))
        retrofit.getConsigneeData(consigneeDataRequest).enqueue(
            object : Callback<ConsigneeDataResponse> {
                override fun onFailure(call: Call<ConsigneeDataResponse>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse(
                    call: Call<ConsigneeDataResponse>,
                    response: Response<ConsigneeDataResponse>
                ) {
                    val addedUser = response.body()
                    onResult(addedUser)
                }
            }
        )
    }
}