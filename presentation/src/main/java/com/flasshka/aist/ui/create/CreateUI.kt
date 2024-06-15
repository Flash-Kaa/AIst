package com.flasshka.aist.ui.create

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.flasshka.aist.domain.entities.ChatModel

@Composable
fun CreateUI(
    nameValue: String,
    keyValue: String,
    modelValue: ChatModel,

    onModelNameChange: (ChatModel) -> Unit,
    onNameChange: (String) -> Unit,
    onKeyChange: (String) -> Unit,
) {
    var opened: Boolean by remember {
        mutableStateOf(false)
    }

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        standardFields(
            nameValue = nameValue,
            keyValue = keyValue,
            modelValue = modelValue,
            onModelNameChange = onModelNameChange,
            onNameChange = onNameChange,
            onKeyChange = onKeyChange
        )

        item {
            Spacer(modifier = Modifier.height(20.dp))
        }

        advancedFields(
            chatModel = modelValue,
            opened = opened,
            onOpenedChange = { opened = it }
        )
    }

    SaveButton()
}

@Preview(showBackground = true)
@Composable
private fun PreviewCreateUI() {
    var nameValue: String by remember {
        mutableStateOf("")
    }

    var keyValue: String by remember {
        mutableStateOf("")
    }

    var modelValue: ChatModel by remember {
        mutableStateOf(ChatModel.GIGACHAT)
    }


    CreateUI(
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