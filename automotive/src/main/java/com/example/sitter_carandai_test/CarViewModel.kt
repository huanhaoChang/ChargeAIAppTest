package com.example.sitter_carandai_test

import android.car.Car
import android.car.VehiclePropertyIds
import android.car.hardware.CarPropertyValue
import android.car.hardware.property.CarPropertyManager
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sitter_carandai_test.util.chargeStateToString
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CarViewModel: ViewModel() {

    private var car: Car? = null
    private val _carState = MutableStateFlow(CarState())
    val carState: StateFlow<CarState> get() = _carState

    private val carPropertyListener = object : CarPropertyManager.CarPropertyEventCallback {

        override fun onChangeEvent(carPropertyValue: CarPropertyValue<*>) {

            viewModelScope.launch{
                when (carPropertyValue.propertyId) {

                    /**
                     * EV_BATTERY_LEVEL  @ EV Battery Level = 291504905 (0x11600309) @ API 29
                     * */
                    VehiclePropertyIds.EV_BATTERY_LEVEL -> {
                        val floatValue = carPropertyValue.value as Float
                        _carState.value = _carState.value.copy(batteryLevel = floatValue)
                    }

                    /**
                     * INFO_EV_BATTERY_CAPACITY @ Battery Capacity = 291504390 (0x11600106) @ API 29
                     */
                    VehiclePropertyIds.INFO_EV_BATTERY_CAPACITY -> {
                        val floatValue = carPropertyValue.value as Float
                        _carState.value = _carState.value.copy(batteryCapacity = floatValue)
                    }

                    /**
                     * EV_BATTERY_INSTANTANEOUS_CHARGE_RATE = 291504908 (0x1160030c) @ API 29
                     */
                    VehiclePropertyIds.EV_BATTERY_INSTANTANEOUS_CHARGE_RATE -> {
                        val floatValue = carPropertyValue.value as Float
                        _carState.value = _carState.value.copy(batteryInstantaneousChargeRate = floatValue)
                    }

                    /**
                     * EV_CURRENT_BATTERY_CAPACITY = 291504909 (0x1160030d) @ API 34
                     */
                    VehiclePropertyIds.EV_CURRENT_BATTERY_CAPACITY -> {
                        val floatValue = carPropertyValue.value as Float
                        _carState.value = _carState.value.copy(batteryCurrentCapacity = floatValue)
                    }

                    /**
                     * EV_CHARGE_STATE = 289410881 (0x11400f41) @ API 33
                     */
                    VehiclePropertyIds.EV_CHARGE_STATE -> {
                        val strValue = chargeStateToString(carPropertyValue.value as Int)
                        _carState.value = _carState.value.copy(chargeState = strValue)
                    }

                    /**
                     * EV_CHARGE_CURRENT_DRAW_LIMIT = 291508031 (0x11600f3f) @ API 33
                     */
                    VehiclePropertyIds.EV_CHARGE_CURRENT_DRAW_LIMIT -> {
                        val floatValue = carPropertyValue.value as Float
                        _carState.value = _carState.value.copy(chargeCurrentDrawLimit = floatValue)
                    }

                    /**
                     * EV_CHARGE_PERCENT_LIMIT = 291508032 (0x11600f40) @ API 33
                     */
                    VehiclePropertyIds.EV_CHARGE_PERCENT_LIMIT -> {
                        val floatValue = carPropertyValue.value as Float
                        _carState.value = _carState.value.copy(chargePercentLimit = floatValue)
                    }

                }
            }

        }

        override fun onErrorEvent(p0: Int, p1: Int) {
            Log.e("CarPropertyListener", "Error: $p0, $p1")
        }

    }
    // ^ CarPropertyListener

    fun setUpCar(context: Context) {

        car = Car.createCar(
            context,
            null,
            Car.CAR_WAIT_TIMEOUT_WAIT_FOREVER,
        ) { car: Car, ready: Boolean ->
            if (ready) {
                val carPropertyManager =
                    car.getCarManager(Car.PROPERTY_SERVICE) as CarPropertyManager

                /**
                 * EV_BATTERY_LEVEL  @ EV Battery Level = 291504905 (0x11600309) @ API 29
                 */
                val batteryLevel =
                    carPropertyManager.getFloatProperty(VehiclePropertyIds.EV_BATTERY_LEVEL, 0)
                        .toString()
                println("GetFloatProperty/ Battery Level: $batteryLevel")
                carPropertyManager.registerCallback(
                    carPropertyListener,
                    VehiclePropertyIds.EV_BATTERY_LEVEL,
                    CarPropertyManager.SENSOR_RATE_ONCHANGE
                )

                /**
                 * INFO_EV_BATTERY_CAPACITY @ Battery Capacity = 291504390 (0x11600106) @ API 29
                 */
                val batteryCapacity =
                    carPropertyManager.getFloatProperty(
                        VehiclePropertyIds.INFO_EV_BATTERY_CAPACITY,
                        0
                    )
                        .toString()
                println("GetFloatProperty/ Battery Capacity: $batteryCapacity")
                carPropertyManager.registerCallback(
                    carPropertyListener,
                    VehiclePropertyIds.INFO_EV_BATTERY_CAPACITY,
                    CarPropertyManager.SENSOR_RATE_NORMAL
                )

                /**
                 * EV_BATTERY_INSTANTANEOUS_CHARGE_RATE = 291504908 (0x1160030c) @ API 29
                 */
                val batteryInstantaneousChargeRate =
                    carPropertyManager.getFloatProperty(
                        VehiclePropertyIds.EV_BATTERY_INSTANTANEOUS_CHARGE_RATE,
                        0
                    )
                        .toString()
                println("GetFloatProperty/ Battery Instantaneous Charge Rate: $batteryInstantaneousChargeRate")
                carPropertyManager.registerCallback(
                    carPropertyListener,
                    VehiclePropertyIds.EV_BATTERY_INSTANTANEOUS_CHARGE_RATE,
                    CarPropertyManager.SENSOR_RATE_ONCHANGE
                )

                /**
                 * EV_CURRENT_BATTERY_CAPACITY = 291504909 (0x1160030d) @ API 34
                 */
                val batteryCurrentCapacity =
                    carPropertyManager.getFloatProperty(
                        VehiclePropertyIds.EV_CURRENT_BATTERY_CAPACITY,
                        0
                    )
                        .toString()
                println("GetFloatProperty/ Battery Current Capacity: $batteryCurrentCapacity")
                carPropertyManager.registerCallback(
                    carPropertyListener,
                    VehiclePropertyIds.EV_CURRENT_BATTERY_CAPACITY,
                    CarPropertyManager.SENSOR_RATE_NORMAL
                )

                /**
                 * EV_CHARGE_STATE = 289410881 (0x11400f41) @ API 33
                 */
                val chargeState =
                    carPropertyManager.getIntProperty(VehiclePropertyIds.EV_CHARGE_STATE, 0)
                        .toString()
                println("GetIntProperty/ Charge State: $chargeState")
                carPropertyManager.registerCallback(
                    carPropertyListener,
                    VehiclePropertyIds.EV_CHARGE_STATE,
                    CarPropertyManager.SENSOR_RATE_NORMAL
                )

                /**
                 * EV_CHARGE_CURRENT_DRAW_LIMIT = 291508031 (0x11600f3f) @ API 33
                 */
                val chargeCurrentDrawLimit =
                    carPropertyManager.getFloatProperty(VehiclePropertyIds.EV_CHARGE_CURRENT_DRAW_LIMIT, 0)
                        .toString()
                println("GetFloatProperty/ Charge Current Draw Limit: $chargeCurrentDrawLimit")
                carPropertyManager.registerCallback(
                    carPropertyListener,
                    VehiclePropertyIds.EV_CHARGE_CURRENT_DRAW_LIMIT,
                    CarPropertyManager.SENSOR_RATE_NORMAL
                )

                /**
                 * EV_CHARGE_PERCENT_LIMIT = 291508032 (0x11600f40) @ API 33
                 */
                val chargePercentLimit =
                    carPropertyManager.getFloatProperty(VehiclePropertyIds.EV_CHARGE_PERCENT_LIMIT, 0)
                        .toString()
                println("GetFloatProperty/ Charge Percent Limit: $chargePercentLimit")
                carPropertyManager.registerCallback(
                    carPropertyListener,
                    VehiclePropertyIds.EV_CHARGE_PERCENT_LIMIT,
                    CarPropertyManager.SENSOR_RATE_NORMAL
                )

            }
        }

    }
    // ^ setUpCar

    fun cleanUpCar() {
        car?.disconnect()
    }

}