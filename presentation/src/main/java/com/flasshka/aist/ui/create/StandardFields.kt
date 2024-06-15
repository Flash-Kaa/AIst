package com.flasshka.aist.ui.create

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.flasshka.aist.domain.entities.ChatModel


fun LazyListScope.standardFields(
    nameValue: String,
    keyValue: String,
    modelValue: ChatModel,

    onModelNameChange: (ChatModel) -> Unit,
    onNameChange: (String) -> Unit,
    onKeyChange: (String) -> Unit,
) {
    item {
        TextFieldDrawer(
            value = nameValue,
            onValueChange = onNameChange,
            label = "Chat name",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        )
    }

    item {
        ChatModelChooser(
            modelValue = modelValue,
            onModelNameChange = onModelNameChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        )
    }

    item {
        TextFieldDrawer(
            value = keyValue,
            onValueChange = onKeyChange,
            label = "Chat api key",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        )
    }
}

@Composable
private fun ChatModelChooser(
    modelValue: ChatModel,
    onModelNameChange: (ChatModel) -> Unit,
    modifier: Modifier = Modifier
) {
    var expendedDM: Boolean by remember {
        mutableStateOf(false)
    }

    TextFieldDrawer(
        value = modelValue.toString(),
        onValueChange = {},
        enabled = false,
        label = "Chat model",
        modifier = modifier
    )

    DropdownMenu(
        expanded = expendedDM,
        onDismissRequest = { expendedDM = false }
    ) {
        for (chatModel in ChatModel.entries) {
            if (chatModel != modelValue) {
                DropdownMenuItem(
                    text = { chatModel.toString() },
                    onClick = { onModelNameChange(chatModel) }
                )
            }
        }
    }
}

@Composable
private fun TextFieldDrawer(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    enabled: Boolean = true
) {
    var labelFun: @Composable (() -> Unit)? = null
    if (label != null) {
        labelFun = {
            Text(text = label)
        }
    }

    TextField(
        value = value,
        onValueChange = onValueChange,
        label = labelFun,
        enabled = enabled,
        colors = TextFieldDefaults.colors(
            disabledLabelColor = Color.Black,
            disabledTextColor = Color.Black
        ),
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewStandardFields() {
    var nameValue: String by remember {
        mutableStateOf("")
    }

    var keyValue: String by remember {
        mutableStateOf("")
    }

    var modelValue: ChatModel by remember {
        mutableStateOf(ChatModel.GIGACHAT)
    }

    LazyColumn {
        standardFields(
            nameValue = nameValue,
            keyValue = keyValue,
            modelValue = modelValue,
            onModelNameChange = {
                modelValue = it
            },
            onNameChange = {
                nameValue = it
            },
            onKeyChange = {
                keyValue = it
            }
        )
    }
}