package com.flasshka.aist.ui.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.flasshka.aist.R
import com.flasshka.aist.ui.theme.AIstTheme


@Composable
fun MessageField(
    value: String,
    onValueChanged: (String) -> Unit,
    onSend: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .border(1.dp, Color.Transparent, RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(
                color = MaterialTheme.colorScheme.secondary,
                RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
            )
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Field(value, onValueChanged, Modifier.weight(6f))

            SendMessageButton(
                onClick = onSend,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun Field(
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChanged,
        placeholder = { Text(text = stringResource(R.string.messageFieldPlaceholder)) },
        shape = RoundedCornerShape(20.dp),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        ),
        modifier = modifier
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .background(color = MaterialTheme.colorScheme.secondary)
    )
}

@Composable
private fun SendMessageButton(
    onClick: () -> Unit,
    modifier: Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .padding(horizontal = 10.dp)
            .size(45.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.baseline_send_24),
            modifier = Modifier.fillMaxSize(),
            contentDescription = ""
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewMessageField() {
    AIstTheme {
        var value: String by remember {
            mutableStateOf("")
        }

        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .imePadding()
                .fillMaxSize()
        ) {
            MessageField(
                value = value,
                onValueChanged = { value = it },
                onSend = {}
            )
        }
    }
}