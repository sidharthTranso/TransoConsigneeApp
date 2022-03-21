package com.example.consigneetransoapp.model

import com.google.gson.annotations.SerializedName

data class ConsigneeDetails(
    @SerializedName("trip_status") val trip_status: String?,
    @SerializedName("destination_address") val destination_address: String?,
    @SerializedName("source_address") val source_address: String?,
    @SerializedName("vendor_lr_number") val vendor_lr_number: String?,
    @SerializedName("customer_lr_number") val customer_lr_number: String?,

)
