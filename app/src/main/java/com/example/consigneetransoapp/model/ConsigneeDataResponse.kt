package com.example.consigneetransoapp.model

import com.google.gson.annotations.SerializedName

data class ConsigneeDataResponse (
    @SerializedName("success") val success: Boolean?,
    @SerializedName("data") val data: ConsigneeDetails?,
)