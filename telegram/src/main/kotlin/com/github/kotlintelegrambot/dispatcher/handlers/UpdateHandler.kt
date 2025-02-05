package com.github.kotlintelegrambot.dispatcher.handlers

import com.github.kotlintelegrambot.Bot
import com.github.kotlintelegrambot.entities.Message
import com.github.kotlintelegrambot.entities.Update
import com.github.kotlintelegrambot.extensions.filters.Filter

data class UpdateHandlerEnvironment(
    val bot: Bot,
    val update: Update
)

internal class UpdateHandler(
    private val filter: Filter,
    private val handleUpdate: UpdateHandlerEnvironment.() -> Unit
) : Handler {

    override fun checkUpdate(update: Update): Boolean = true

    override suspend fun handleUpdate(bot: Bot, update: Update) {
        val updateHandlerEnv = UpdateHandlerEnvironment(bot, update)
        handleUpdate(updateHandlerEnv)
    }
}
