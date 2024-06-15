package com.flasshka.aist.domain.entities

data class Message(
    val sender: Sender,
    val text: String,
    val title: ChatTitle
)
