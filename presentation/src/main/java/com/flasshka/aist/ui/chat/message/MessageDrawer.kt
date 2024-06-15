package com.flasshka.aist.ui.chat.message

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.flasshka.aist.R
import com.flasshka.aist.domain.entities.Message
import com.flasshka.aist.domain.entities.Sender

@Composable
fun MessageDrawer(
    message: Message,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 8.dp)
    ) {
        if (message.sender == Sender.BOT) {
            BotIcon(
                imageId = message.title.imageId,
                modifier = Modifier.weight(1f)
            )
        }

        MessageText(message = message, Modifier.weight(7f))

        if (message.sender == Sender.USER) {
            UserIcon(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
private fun BotIcon(imageId: Int, modifier: Modifier = Modifier) {
    Image(
        bitmap = ImageBitmap.imageResource(id = imageId),
        modifier = modifier.clip(CircleShape),
        contentDescription = "bot message icon"
    )
}

@Composable
private fun MessageText(
    message: Message,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = getTextAlign(message.sender),
        modifier = modifier.padding(horizontal = 5.dp)
    ) {
        val needDropdown: MutableState<Boolean> = remember {
            mutableStateOf(false)
        }

        Text(
            text = message.text,
            modifier = Modifier
                .clickable {
                    needDropdown.value = !needDropdown.value
                    /*
                    TODO: dropdown menu: getAction.getCopy(context, clipboard, message) or deleteMessage
                    clipboard.setText(AnnotatedString(message.text))
                    Toast.makeText(toastContext, "Message has been copied", Toast.LENGTH_SHORT).show()
                    */
                }
                .padding(horizontal = 5.dp)
                .background(getBackgroundForText(message.sender), RoundedCornerShape(15.dp))
                .padding(15.dp)
        )

        if (needDropdown.value) {
            DropdownMessageMenu(message, needDropdown)
        }
    }
}

@Composable
private fun getBackgroundForText(sender: Sender): Color {
    return when (sender) {
        Sender.BOT -> colorResource(id = R.color.bot_bg_message)
        Sender.USER -> colorResource(id = R.color.user_bg_message)
        else -> colorResource(id = R.color.system_bg_message)
    }
}

fun getTextAlign(sender: Sender): Alignment {
    return when (sender) {
        Sender.BOT -> Alignment.CenterStart
        Sender.USER -> Alignment.CenterEnd
        else -> Alignment.Center
    }
}

@Composable
private fun UserIcon(modifier: Modifier = Modifier) {
    Image(
        bitmap = ImageBitmap.imageResource(id = R.drawable.user_icon),
        modifier = modifier.clip(CircleShape),
        contentDescription = "bot message icon"
    )
}