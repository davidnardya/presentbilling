package com.davidnardya.payplustest.models


import com.google.gson.annotations.SerializedName

data class BillingEntryHeader(
    @SerializedName("cardType")
    val cardType: String? = "",
    @SerializedName("created")
    val created: Int? = 0,
    @SerializedName("currencyCode")
    val currencyCode: String? = "",
    @SerializedName("entryNumber")
    val entryNumber: Int? = 0,
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("price")
    val price: Double? = 0.0,
    @SerializedName("source")
    val source: String? = "",
    @SerializedName("totalEntryCount")
    val totalEntryCount: Int? = 0
)