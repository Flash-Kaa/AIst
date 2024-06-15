package com.flasshka.aist.domain.usecases

import com.flasshka.aist.domain.entities.ChatTitle

fun List<ChatTitle>.getWithout(without: ChatTitle): List<ChatTitle> {
    return this.filter { it != without }
}