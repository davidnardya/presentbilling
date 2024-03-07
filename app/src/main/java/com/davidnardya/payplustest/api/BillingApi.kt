package com.davidnardya.payplustest.api

import com.davidnardya.payplustest.models.BillingEntryDetailsResponse
import com.davidnardya.payplustest.models.BillingHeaderListResponse
import com.davidnardya.payplustest.models.DeleteBillingEntryResponse
import retrofit2.http.POST

interface BillingApi {

    @POST("payment/billing/entry/headers")
    suspend fun getBilling(): BillingHeaderListResponse? = BillingHeaderListResponse()

    @POST("payment/billing/entry/details")
    suspend fun getBillingDetails(billingId: Long): BillingEntryDetailsResponse? = BillingEntryDetailsResponse()

    @POST("payment/billing/entry/delete")
    suspend fun delete(billingId: Long): DeleteBillingEntryResponse? = DeleteBillingEntryResponse()
}