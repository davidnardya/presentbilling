package com.davidnardya.payplustest.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidnardya.payplustest.models.BillingEntryDetailsResponse
import com.davidnardya.payplustest.models.BillingEntryHeader
import com.davidnardya.payplustest.models.BillingHeaderListResponse
import com.davidnardya.payplustest.repositories.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    val billingHeaderLiveData = MutableLiveData<BillingHeaderListResponse>()
    val currentBillingEntryLiveData = MutableLiveData<BillingEntryDetailsResponse?>()

    suspend fun getBilling() {
        mainRepository.getBilling()?.let {
            Log.d("123321",it.toString())
            billingHeaderLiveData.postValue(it)
        }
    }

    fun getBillingDetails(billingId: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            currentBillingEntryLiveData.postValue(mainRepository.getBillingDetails(billingId))
        }
    }

    suspend fun delete(billingId: Long) = mainRepository.delete(billingId)
}