package com.example.danh_ba

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    var ID: String,
    var Name: String,
    var SDT: String,
    var Email: String
) :Parcelable
