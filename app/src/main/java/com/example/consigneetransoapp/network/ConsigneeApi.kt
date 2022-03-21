package com.example.consigneetransoapp.network

import com.example.consigneetransoapp.model.ConsigneeDataRequest
import com.example.consigneetransoapp.model.ConsigneeDataResponse
import retrofit2.Call
import retrofit2.http.*

interface ConsigneeApi {
    @Headers("Content-Type: application/json")
    @GET("trip/ShipmentTrackingByVendorLr")
    fun getConsigneeData(@Query("vendorLrNumber") vendor_lr_number:String): Call<ConsigneeDataResponse>



}