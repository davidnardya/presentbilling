package com.davidnardya.payplustest.models

import com.google.gson.annotations.SerializedName

data class DeleteBillingEntryResponse(
    @SerializedName("status")
    val status: Int? = -1 // will be == 0 if success
)