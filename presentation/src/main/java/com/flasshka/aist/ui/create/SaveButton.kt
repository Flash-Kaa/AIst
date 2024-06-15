package com.flasshka.aist.ui.create

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.flasshka.aist.R

@Composable
fun SaveButton(
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        FloatingActionButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.size(80.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_done_24),
                modifier = Modifier.size(50.dp),
                contentDescription = "save icon"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewCreateButton() {
    SaveButton(
        modifier = Modifier
    )
}