package com.davidnardya.payplustest.di

import com.davidnardya.payplustest.Constants.BASE_URL
import com.davidnardya.payplustest.api.BillingApi
import com.davidnardya.payplustest.api.createRetrofitInstance
import com.davidnardya.payplustest.repositories.MainRepository
import com.davidnardya.payplustest.viewmodels.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        billingApi: BillingApi
    ) = MainRepository(billingApi)

    @Singleton
    @Provides
    fun provideMainViewModel(mainRepository: MainRepository) = MainViewModel(mainRepository)

    @Singleton
    @Provides
    fun provideBillingApi(): BillingApi = createRetrofitInstance(BASE_URL)
}