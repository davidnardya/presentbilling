package com.davidnardya.payplustest.models


import com.google.gson.annotations.SerializedName

data class BillingHeaderListResponse(
    @SerializedName("headers")
    val headers: List<BillingEntryHeader>? = emptyList()
)