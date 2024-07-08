package com.example.sitter_carandai_test

import android.graphics.Bitmap

sealed class ChatUiEvent {

    data class UpdatePrompt(val newPrompt: String): ChatUiEvent()

    data class SendPrompt(val userMessage: String, val carStatus: String): ChatUiEvent()

}