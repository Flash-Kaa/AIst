package com.flasshka.aist.ui.chat.message

import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.flasshka.aist.R
import com.flasshka.aist.domain.entities.Message

@Composable
fun DropdownMessageMenu(
    message: Message,
    needDropdown: MutableState<Boolean>
) {
    DropdownMenu(
        expanded = needDropdown.value,
        onDismissRequest = { needDropdown.value = false }
    ) {
        CopyMessage(
            message = message,
            needDropdown = needDropdown,
        )

        DeleteMessage(
            message = message,
            needDropdown = needDropdown
        )
    }
}

@Composable
private fun CopyMessage(
    message: Message,
    needDropdown: MutableState<Boolean>
) {
    val clipboard: ClipboardManager = LocalClipboardManager.current
    val toastContext = LocalContext.current

    DropdownMenuItem(
        text = { Text(text = "Copy") },
        onClick = {
            needDropdown.value = false
            /*TODO: getAction.getCopy(context, clipboard, message) with toast*/
        },
        leadingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_content_copy_24),
                modifier = Modifier.size(30.dp),
                contentDescription = "copy icon"
            )
        }
    )
}

@Composable
private fun DeleteMessage(
    message: Message,
    needDropdown: MutableState<Boolean>
) {
    val toastContext = LocalContext.current

    DropdownMenuItem(
        text = { Text(text = "Delete") },
        onClick = {
            needDropdown.value = false
            /*TODO: getAction.deleteMessage(message) with toast*/
        },
        leadingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_delete_24),
                modifier = Modifier.size(30.dp),
                contentDescription = "delete icon"
            )
        }
    )
}