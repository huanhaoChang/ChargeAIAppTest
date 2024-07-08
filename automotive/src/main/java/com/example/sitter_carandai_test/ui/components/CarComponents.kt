package com.example.sitter_carandai_test.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


@Composable
fun CarScreen(
    batteryLevel: Float?,
    batteryCapacity: Float?,
    batteryInstantaneousChargeRate: Float?,
    batteryCurrentCapacity: Float?,
    chargeState: String?,
    chargeCurrentDrawLimit: Float?,
    chargePercentLimit: Float?,
//    chargePortConnected: Boolean?,
) {
    Text(text = "CAR PROPERTIES\n", fontSize = 20.sp, color = Color.White)
    BatteryLevel(level = batteryLevel)
    BatteryCapacity(capacity = batteryCapacity)
    BatteryInstantaneousChargeRate(rate = batteryInstantaneousChargeRate)
    BatteryCurrentCapacity(capacity = batteryCurrentCapacity)
    ChargeState(state = chargeState)
    ChargeCurrentDrawLimit(limit = chargeCurrentDrawLimit)
    ChargePercentLimit(limit = chargePercentLimit)
}

/**
 * EV_BATTERY_LEVEL  @ EV Battery Level = 291504905 (0x11600309) @ API 29
 */
@Composable
fun BatteryLevel(level: Float?) {
    Text(
        text = "Battery Level (API 29):\n$level",
        fontSize = 16.sp,
        color = Color.White,
        textAlign = TextAlign.Center
    )
}

/**
 * INFO_EV_BATTERY_CAPACITY @ Battery Capacity = 291504390 (0x11600106) @ API 29
 */
@Composable
fun BatteryCapacity(capacity: Float?) {
    Text(
        text = "Battery Capacity (API 29):\n$capacity",
        fontSize = 16.sp,
        color = Color.White,
        textAlign = TextAlign.Center
    )
}

/**
 * EV_BATTERY_INSTANTANEOUS_CHARGE_RATE = 291504908 (0x1160030c) @ API 29
 */
@Composable
fun BatteryInstantaneousChargeRate(rate: Float?) {
    Text(
        text = "Battery Instantaneous Charge Rate (API 29):\n$rate",
        fontSize = 16.sp,
        color = Color.White,
        textAlign = TextAlign.Center
    )
}

/**
 * EV_CURRENT_BATTERY_CAPACITY = 291504909 (0x1160030d) @ API 34
 */
@Composable
fun BatteryCurrentCapacity(capacity: Float?) {
    Text(
        text = "Battery Current Capacity (API 34):\n$capacity",
        fontSize = 16.sp,
        color = Color.White,
        textAlign = TextAlign.Center
    )
}

/**
 * EV_CHARGE_STATE = 289410881 (0x11400f41) @ API 33
 */
@Composable
fun ChargeState(state: String?) {
    Text(
        text = "Charge State (API 33):\n$state",
        fontSize = 16.sp,
        color = Color.White,
        textAlign = TextAlign.Center
    )
}

/**
 * EV_CHARGE_CURRENT_DRAW_LIMIT = 291508031 (0x11600f3f) @ API 33
 */
@Composable
fun ChargeCurrentDrawLimit(limit: Float?) {
    Text(
        text = "Charge Current Draw Limit (API 33):\n$limit",
        fontSize = 16.sp,
        color = Color.White,
        textAlign = TextAlign.Center
    )
}

/**
 * EV_CHARGE_PERCENT_LIMIT = 291508032 (0x11600f40) @ API 33
 */
@Composable
fun ChargePercentLimit(limit: Float?) {
    Text(
        text = "Charge Percent Limit (API 33):\n$limit",
        fontSize = 16.sp,
        color = Color.White,
        textAlign = TextAlign.Center
    )
}
