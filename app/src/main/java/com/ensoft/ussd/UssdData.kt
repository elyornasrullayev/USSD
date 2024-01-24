package com.ensoft.ussd

data class UssdData(
    val ussdCode: String,
    val ussdHeader: String,
    val ussdDesc: String,
    var isExpandable: Boolean = false
)