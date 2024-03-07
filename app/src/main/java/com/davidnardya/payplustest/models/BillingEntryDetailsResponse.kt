package com.davidnardya.payplustest.models

import com.google.gson.annotations.SerializedName

data class BillingEntryDetailsResponse(
    @SerializedName("details")
    val details: BillingEntryDetails? = null
)
