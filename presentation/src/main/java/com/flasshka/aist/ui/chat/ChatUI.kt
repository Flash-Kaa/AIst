package com.flasshka.aist.ui.chat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.flasshka.aist.R
import com.flasshka.aist.domain.entities.ChatTitle
import com.flasshka.aist.domain.entities.Message
import com.flasshka.aist.domain.entities.Sender

@Composable
fun ChatUI(
    value: String,
    onValueChanged: (String) -> Unit,
    onSend: () -> Unit,
    currentTitle: ChatTitle,
    chatTitles: List<ChatTitle>,
    history: List<Message>
) {
    Column {
        ChatTab(
            currentTitle = currentTitle,
            chatTitles = chatTitles, 
            modifier = Modifier
                .weight(1f)
        )
        
        MessageHistory(
            history = history,
            modifier = Modifier.weight(10f)
            )
        
        MessageField(
            value = value,
            onValueChanged = onValueChanged,
            onSend = onSend,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewChatUI() {
    var value: String by remember {
        mutableStateOf("")
    }

    val currentTitle = ChatTitle(
        name = "hellohellohellohhellohellohellohhellohellohellohhellohellohelloh",
        imageId = R.drawable.gigachat_icon
    )

    val tabs: MutableList<ChatTitle> = MutableList<ChatTitle>(10) {
        ChatTitle(
            name = "name: $it",
            imageId = R.drawable.gigachat_icon
        )
    }

    tabs[3] = currentTitle

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

    ChatUI(
        value = value,
        onValueChanged = { value = it },
        onSend = {  },
        currentTitle = currentTitle,
        chatTitles = tabs,
        history = history
    )
}