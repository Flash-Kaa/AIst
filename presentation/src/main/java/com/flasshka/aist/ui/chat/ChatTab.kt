package com.flasshka.aist.ui.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.flasshka.aist.R
import com.flasshka.aist.domain.entities.ChatTitle
import com.flasshka.aist.domain.usecases.getWithout
import com.flasshka.aist.ui.theme.AIstTheme

@Composable
fun ChatTab(
    currentTitle: ChatTitle,
    chatTitles: List<ChatTitle>,
    modifier: Modifier
) {
    val exp: MutableState<Boolean> = remember {
        mutableStateOf(false)
    }

    Column (modifier = modifier){
        ChatTitle(
            chatTitle = currentTitle,
            modifier = Modifier.clickable { exp.value = !exp.value }
        )

        DropdownMenu(
            expanded = exp.value,
            onDismissRequest = { exp.value = false }
        ) {
            CreateChatItem(
                exp = exp
            )

            ChatTitlesItems(
                currentTitle = currentTitle,
                chatTitles = chatTitles,
                exp = exp
            )
        }
    }
}

@Composable
private fun ChatTitle(
    chatTitle: ChatTitle,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .background(Color.Green /*TODO*/)
            .padding(10.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            bitmap = ImageBitmap.imageResource(id = chatTitle.imageId),
            modifier = Modifier.clip(CircleShape),
            contentDescription = "tab description"
        )

        Text(
            text = chatTitle.name,
            fontSize = 20.sp,
            maxLines = 1,
            modifier = Modifier.padding(start = 10.dp).weight(5f)
        )

        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.baseline_keyboard_arrow_down_24),
            modifier = Modifier.weight(1f),
            contentDescription = "open dropdown menu"
        )
    }
}

@Composable
private fun CreateChatItem(
    exp: MutableState<Boolean>
) {
    DropdownMenuItem(
        text = { Text(text = stringResource(R.string.create_chat)) },
        onClick = { exp.value = false; /*TODO*/ },
        leadingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_add_24),
                modifier = Modifier.sizeIn(minWidth = 30.dp, maxWidth = 45.dp),
                contentDescription = "dropdown trail icon"
            )
        }
    )
}

@Composable
fun ChatTitlesItems(
    currentTitle: ChatTitle,
    chatTitles: List<ChatTitle>,
    exp: MutableState<Boolean>
) {
    chatTitles.getWithout(currentTitle).forEach {
        DropdownMenuItem(
            text = { Text(text = it.name, maxLines = 1) },
            onClick = { exp.value = false; /*TODO*/ },
            leadingIcon = {
                Image(
                    bitmap = ImageBitmap.imageResource(id = it.imageId),
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape),
                    contentDescription = "dropdown lead icon"
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_delete_24),
                    modifier = Modifier
                        .sizeIn(minWidth = 30.dp, maxWidth = 45.dp)
                        .clickable { /*TODO*/ },
                    contentDescription = "dropdown trail icon"
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewChatTab() {
    val list: MutableList<ChatTitle> = MutableList<ChatTitle>(10) {
        ChatTitle(
            name = "name: $it",
            imageId = R.drawable.gigachat_icon
        )
    }

    list[5] = ChatTitle(
        name = "longlonglonglonglonglonglonglong",
        imageId = R.drawable.gigachat_icon
    )

    AIstTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            ChatTab(
                currentTitle = list[3],
                chatTitles = list,
                modifier = Modifier.height(50.dp)
            )
        }
    }
}