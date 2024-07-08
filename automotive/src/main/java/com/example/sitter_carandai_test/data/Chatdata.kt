package com.example.sitter_carandai_test.data

import android.graphics.Bitmap
import com.example.sitter_carandai_test.BuildConfig
import com.example.sitter_carandai_test.data.prompts.TROUBLE_SHOOTING_MANUAL
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.FunctionResponsePart
import com.google.ai.client.generativeai.type.InvalidStateException
import com.google.ai.client.generativeai.type.Schema
import com.google.ai.client.generativeai.type.Tool
import com.google.ai.client.generativeai.type.content
import com.google.ai.client.generativeai.type.defineFunction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject

object ChatData {

    private const val API_KEY = BuildConfig.apiKey

    suspend fun getResponse(prompt: String): Chat {

        val systemPrompt = """
            You are an assistant that can help with automotive-related tasks.
            You will be given prompts consisting of user's message and current car's battery and charging status with 'CAR_STATUS' tag.
            
            Response with not more than 200 words and keep the answer concise.
            Take reference of CAR_STATUS and TROUBLE_SHOOTING_MANUAL information if user's message is related to them.
            Use CAR_STATUS information only if user's message is related to car battery and charging status.
            Use TROUBLE_SHOOTING_MANUAL information if user's message is related to car's charging problem.
            If user's message is not related to car battery and charging status or trouble, respond as general conversation.
            If you need more information, ask follow-up question to user.
            
            TROUBLE_SHOOTING_MANUAL:
            $TROUBLE_SHOOTING_MANUAL
            
        """.trimIndent()

        val generativeModel = GenerativeModel(
            modelName = "gemini-1.5-pro",
            apiKey = API_KEY,
            systemInstruction = content(role = "system") {
                text(systemPrompt)
            },
        )

        try {
            val response = withContext(Dispatchers.IO) {
                generativeModel.generateContent(prompt)
            }
            return Chat(
                prompt = response.text ?: "error",
                isFromUser = false,
            )
        } catch (e: Exception) {
            return Chat(
                prompt = e.message ?: "error",
                isFromUser = false,
            )
        }

    }

}