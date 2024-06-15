package com.flasshka.aist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.flasshka.aist.domain.entities.ChatTitle
import com.flasshka.aist.ui.chat.ChatTab
import com.flasshka.aist.ui.theme.AIstTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AIstTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.imePadding().fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val list: List<ChatTitle> = List<ChatTitle>(10) {
                        ChatTitle(
                            name = "name: $it",
                            imageId = R.drawable.ic_launcher_foreground
                        )
                    }


                    ChatTab(
                        currentTitle = list[3],
                        chatTitles = list,
                        modifier = Modifier.height(50.dp)
                    )
                }
            }
        }
    }
}