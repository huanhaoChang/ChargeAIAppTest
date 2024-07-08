package com.example.sitter_carandai_test

import android.car.Car
import android.car.VehiclePropertyIds
import android.car.hardware.CarPropertyValue
import android.car.hardware.property.CarPropertyManager
import android.car.hardware.property.EvChargeState
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sitter_carandai_test.ui.components.BatteryCapacity
import com.example.sitter_carandai_test.ui.components.BatteryCurrentCapacity
import com.example.sitter_carandai_test.ui.components.BatteryInstantaneousChargeRate
import com.example.sitter_carandai_test.ui.components.BatteryLevel
import com.example.sitter_carandai_test.ui.components.CarScreen
import com.example.sitter_carandai_test.ui.components.ChargeCurrentDrawLimit
import com.example.sitter_carandai_test.ui.components.ChargeState
import com.example.sitter_carandai_test.ui.components.ChatScreen
import com.example.sitter_carandai_test.ui.theme.SitterCarAndAITestTheme
import com.example.sitter_carandai_test.util.chargeStateToString

class MainActivity : ComponentActivity() {

    private val carViewModel: CarViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val hasCarEnergyPermission = ActivityCompat.checkSelfPermission(
            this,
            Car.PERMISSION_ENERGY
        ) == PackageManager.PERMISSION_GRANTED

        if (hasCarEnergyPermission) {
            carViewModel.setUpCar(this)
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Car.PERMISSION_ENERGY),
                0
            )
        }

        setContent {
            SitterCarAndAITestTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.onBackground
                ) {
                    val state = carViewModel.carState.collectAsState().value

                    MainScreen(
                        mBatteryLevel = state.batteryLevel,
                        mBatteryCapacity = state.batteryCapacity,
                        mBatteryInstantaneousChargeRate = state.batteryInstantaneousChargeRate,
                        mBatteryCurrentCapacity = state.batteryCurrentCapacity,
                        mChargeState = state.chargeState,
                        mChargeCurrentDrawLimit = state.chargeCurrentDrawLimit,
                        mChargePercentLimit = state.chargePercentLimit,
                    )
                }

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        carViewModel.cleanUpCar()
    }

}

@Composable
fun MainScreen(
    mBatteryLevel: Float?,
    mBatteryCapacity: Float?,
    mBatteryInstantaneousChargeRate: Float?,
    mBatteryCurrentCapacity: Float?,
    mChargeState: String?,
    mChargeCurrentDrawLimit: Float?,
    mChargePercentLimit: Float?,
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(Color.DarkGray)
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CarScreen(
                batteryLevel = mBatteryLevel,
                batteryCapacity = mBatteryCapacity,
                batteryInstantaneousChargeRate = mBatteryInstantaneousChargeRate,
                batteryCurrentCapacity = mBatteryCurrentCapacity,
                chargeState = mChargeState,
                chargeCurrentDrawLimit = mChargeCurrentDrawLimit,
                chargePercentLimit = mChargePercentLimit,
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(2f)
                .background(Color.DarkGray)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ChatScreen(
                batteryLevel = mBatteryLevel,
                batteryCapacity = mBatteryCapacity,
                batteryInstantaneousChargeRate = mBatteryInstantaneousChargeRate,
                batteryCurrentCapacity = mBatteryCurrentCapacity,
                chargeState = mChargeState,
                chargeCurrentDrawLimit = mChargeCurrentDrawLimit,
                chargePercentLimit = mChargePercentLimit,
            )
        }

    }
}