package com.nateshmbhat.card_scanner.scanner_core.models

import android.os.Parcel
import android.os.Parcelable

//@author nateshmbhat created on 27,June,2020

class CardDetails(
        private var cardNumber: String,
        private var cardIssuer: String = "",
        private var cardHolderName: String = "",
        private var validFromDate: String = "",
        private var expiryDate: String = "") : Parcelable {

  constructor(parcel: Parcel) : this(
          parcel.readString(),
          parcel.readString(),
          parcel.readString(),
          parcel.readString(),
          parcel.readString()) {
  }

  fun toMap(): Map<String, String> {
    val map = mutableMapOf<String, String>()
    map.put("cardNumber", cardNumber)
    map.put("cardIssuer", cardIssuer)
    map.put("cardHolderName", cardHolderName)
    map.put("validFromDate", validFromDate)
    map.put("expiryDate", expiryDate)
    return map.toMap()
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeString(cardNumber)
    parcel.writeString(cardIssuer)
    parcel.writeString(cardHolderName)
    parcel.writeString(validFromDate)
    parcel.writeString(expiryDate)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<CardDetails> {
    override fun createFromParcel(parcel: Parcel): CardDetails {
      return CardDetails(parcel)
    }

    override fun newArray(size: Int): Array<CardDetails?> {
      return arrayOfNulls(size)
    }
  }
}