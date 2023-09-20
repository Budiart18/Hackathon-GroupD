package com.aeryz.hackathon3_groupd.model

import android.os.Parcelable
import com.aeryz.hackathon3_groupd.data.ProductDataSource
import kotlinx.android.parcel.Parcelize
import java.util.UUID

@Parcelize
data class Product (
    val id: String = UUID.randomUUID().toString(),
    val position : Int,
    val name: String,
    val price: Double,
    val weight: Int,
    val supplierName: String,
    val rating: Double,
    val desc: String,
    val imgUrl : String,
): Parcelable