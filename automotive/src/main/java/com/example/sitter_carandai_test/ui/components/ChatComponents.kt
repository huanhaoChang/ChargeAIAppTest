package com.example.sitter_carandai_test.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sitter_carandai_test.ChatUiEvent
import com.example.sitter_carandai_test.ChatViewModel

@Composable
fun ChatScreen(
    batteryLevel: Float?,
    batteryCapacity: Float?,
    batteryInstantaneousChargeRate: Float?,
    batteryCurrentCapacity: Float?,
    chargeState: String?,
    chargeCurrentDrawLimit: Float?,
    chargePercentLimit: Float?,
) {

    val chatViewModel = viewModel<ChatViewModel>()
    val chatState = chatViewModel.chatState.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            reverseLayout = true
        ) {
            itemsIndexed(chatState.chatList) { index, chat ->
                if (chat.isFromUser) {
                    UserChatItem(
                        prompt = chat.prompt
                    )
                } else {
                    ModelChatItem(
                        response = chat.prompt
                    )
                }

            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            TextField(
                modifier = Modifier.weight(1f),
                value = chatState.prompt,
                onValueChange = {
                    chatViewModel.onEvent(ChatUiEvent.UpdatePrompt(it))
                },
                placeholder = {
                    Text(text = "Type a Prompt")
                }
            )

            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                modifier = Modifier
                    .size(40.dp)
                    .clickable {
                        val userMessage = chatState.prompt
                        val carStatus = "CAR_STATUS:" +
                                if (batteryLevel != null) "\nBattery Level (Unit: Wh): $batteryLevel" else "" +
                                if (batteryCapacity != null) "\nBattery Capacity (Unit: Wh): $batteryCapacity" else "" +
                                if (batteryInstantaneousChargeRate != null) "\nBattery Instantaneous Charge Rate (Unit: W): $batteryInstantaneousChargeRate" else "" +
                                if (batteryCurrentCapacity != null) "\nBattery Current Capacity (Unit: Wh): $batteryCurrentCapacity" else "" +
                                if (chargeState != null) "\nCharge State: $chargeState" else "" +
                                if (chargeCurrentDrawLimit != null) "\nCharge Current Draw Limit (Unit: A): $chargeCurrentDrawLimit" else "" +
                                if (chargePercentLimit != null) "\nCharge Percent Limit (Unit: %): $chargePercentLimit" else ""
                        chatViewModel.onEvent(ChatUiEvent.SendPrompt(userMessage, carStatus))
                    },
                imageVector = Icons.AutoMirrored.Rounded.Send,
                contentDescription = "Send prompt",
                tint = MaterialTheme.colorScheme.primary
            )

        }

    }

}

@Composable
fun UserChatItem(prompt: String) {
    Column(
        modifier = Modifier.padding(start = 100.dp, bottom = 22.dp)
    ) {

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.primary)
                .padding(16.dp),
            text = prompt,
            fontSize = 17.sp,
            color = MaterialTheme.colorScheme.onPrimary
        )

    }
}

@Composable
fun ModelChatItem(response: String) {
    Column(
        modifier = Modifier.padding(end = 100.dp, bottom = 22.dp)
    ) {

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.tertiary)
                .padding(16.dp),
            text = response,
            fontSize = 17.sp,
            color = MaterialTheme.colorScheme.onTertiary
        )

    }
}