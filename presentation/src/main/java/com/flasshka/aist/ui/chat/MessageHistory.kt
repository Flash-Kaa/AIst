package com.flasshka.aist.ui.chat

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.flasshka.aist.R
import com.flasshka.aist.domain.entities.ChatTitle
import com.flasshka.aist.domain.entities.Message
import com.flasshka.aist.domain.entities.Sender
import com.flasshka.aist.ui.chat.message.MessageDrawer

@Composable
fun MessageHistory(
    history: List<Message>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        reverseLayout = true,
        modifier = modifier.fillMaxSize()
    ) {
        items(history) {
            MessageDrawer(it)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewMessageHistory() {
    val history = listOf<Message>(
        Message(
            Sender.BOT,
            "hellohellohellohhellohellohellohhellohellohellohhellohellohelloh" +
                    "hellohellohellohhellohellohellohhellohellohellohhellohellohelloh",
            ChatTitle(
                "title",
                R.drawable.gigachat_icon
            )
        ),
        Message(
            Sender.USER,
            "hellohellohellohhellohellohellohhellohellohellohhellohellohelloh" +
                    "hellohellohellohhellohellohellohhellohellohellohhellohellohellohh",
            ChatTitle(
                "title",
                R.drawable.gigachat_icon
            )
        ),
        Message(
            Sender.SYSTEM,
            "hellohellohellohhellohellohellohhellohellohellohhellohellohelloh",
            ChatTitle(
                "title",
                R.drawable.gigachat_icon
            )
        )
    )

    MessageHistory(history = history.reversed())
}

