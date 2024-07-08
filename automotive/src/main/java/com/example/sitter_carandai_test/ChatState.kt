package com.example.sitter_carandai_test

import android.graphics.Bitmap
import com.example.sitter_carandai_test.data.Chat

data class ChatState(
    val chatList: MutableList<Chat> = mutableListOf(),
    val prompt: String = "",
)