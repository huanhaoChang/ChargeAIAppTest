package com.example.sitter_carandai_test

data class CarState(
    val batteryLevel: Float? = null,
    val batteryCapacity: Float? = null,
    val batteryInstantaneousChargeRate: Float? = null,
    val batteryCurrentCapacity: Float? = null,
    val chargeState: String? = null,
    val chargeCurrentDrawLimit: Float? = null,
    val chargePercentLimit: Float? = null,
)