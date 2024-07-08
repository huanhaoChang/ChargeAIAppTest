package com.example.sitter_carandai_test.util

import android.car.hardware.property.EvChargeState

fun chargeStateToString(state: Int): String {
    return when (state) {
        EvChargeState.STATE_CHARGING -> "STATE_CHARGING"
        EvChargeState.STATE_ERROR -> "STATE_ERROR"
        EvChargeState.STATE_FULLY_CHARGED -> "STATE_FULLY_CHARGED"
        EvChargeState.STATE_NOT_CHARGING -> "STATE_NOT_CHARGING"
        else -> "Unknown State"
    }
}