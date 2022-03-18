package com.example.consigneetransoapp.model

import com.google.gson.annotations.SerializedName

data class ConsigneeDataRequest (
    @SerializedName("user_username") val userUserName: String?
)