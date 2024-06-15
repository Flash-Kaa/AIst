package com.flasshka.aist.ui.create

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.flasshka.aist.R
import com.flasshka.aist.domain.entities.ChatModel

fun LazyListScope.advancedFields(
    chatModel: ChatModel,
    opened: Boolean,
    onOpenedChange: (Boolean) -> Unit,
) {

    item {
        AdvancedFieldsOpener(
            opened = opened,
            onOpenedChange = onOpenedChange
        )
    }

    if (opened) {
        // TODO: use chat model
        // fields with item {}
    }
}

@Composable
private fun AdvancedFieldsOpener(
    opened: Boolean,
    onOpenedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(30.dp)
            .clickable { onOpenedChange(!opened) }
    ) {
        Text(
            text = stringResource(R.string.advanced_settings),
            fontSize = 20.sp,
            modifier = Modifier
                .weight(5f)
        )

        val resource = if (opened.not())
            R.drawable.baseline_keyboard_arrow_down_24
        else
            R.drawable.baseline_keyboard_arrow_up_24

        Icon(
            imageVector = ImageVector.vectorResource(id = resource),
            modifier = Modifier
                .padding(start = 10.dp)
                .weight(2f),
            contentDescription = "open advanced settings"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewAdvanced() {
    var opened: Boolean by remember {
        mutableStateOf(false)
    }

    LazyColumn {
        advancedFields(
            chatModel = ChatModel.GIGACHAT,
            opened = opened,
            onOpenedChange = { opened = it }
        )
    }
}