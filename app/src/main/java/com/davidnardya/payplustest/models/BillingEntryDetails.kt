package com.davidnardya.payplustest.models

import com.google.gson.annotations.SerializedName

data class BillingEntryDetails(
    @SerializedName("id")
    val id: Long? = 0L,
    @SerializedName("price")
    val price: Double? = 0.0,
    @SerializedName("created")
    val created: Long? = 0L,
    @SerializedName("entryNumber")
    val entryNumber: Int? = 0,
    @SerializedName("totalEntryCount")
    val totalEntryCount: Int? = 0,
    @SerializedName("currencyCode")
    val currencyCode: String? = "", // USD,  ILS
    @SerializedName("amountPaid")
    val amountPaid: Double? = 0.0,
    @SerializedName("status")
    val status: String? = "", // Passed, Rejected
    @SerializedName("cardNumber")
    val cardNumber: String? = "",
    @SerializedName("cardType")
    val cardType: String? = "", // Visa, MasterCard, Diners, Amex, Isracard, Discover, Meastro, Max
    @SerializedName("issuer")
    val issuer: String? = "" ,// Isracard, Visacal, Diners, Amex, Jcb, Max
    @SerializedName("source")
    val source: String? = "", // Terminal, Pos, Manual
    @SerializedName("terminalName")
    val terminalName: String? = "",
    @SerializedName("approvalNumber")
    val approvalNumber: String? = "",
    @SerializedName("voucherNumber")
    val voucherNumber: String? = ""

)
