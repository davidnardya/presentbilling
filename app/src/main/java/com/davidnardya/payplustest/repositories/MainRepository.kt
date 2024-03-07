package com.davidnardya.payplustest.repositories

import android.util.Log
import com.davidnardya.payplustest.api.BillingApi
import javax.inject.Inject

class MainRepository @Inject constructor(private val billingApi: BillingApi) {
    val TAG = this@MainRepository::class.java.simpleName

    suspend fun getBilling() = try {
        billingApi.getBilling()
    } catch (e: Exception) {
        Log.e(TAG, e.message.toString())
        null
    }

    suspend fun getBillingDetails(billingId: Long) = try {
        billingApi.getBillingDetails(billingId)
    } catch (e: Exception) {
        Log.e(TAG, e.message.toString())
        null
    }
    suspend fun delete(billingId: Long) = try {
        billingApi.delete(billingId)
    } catch (e: Exception) {
        Log.e(TAG, e.message.toString())
        null
    }
}