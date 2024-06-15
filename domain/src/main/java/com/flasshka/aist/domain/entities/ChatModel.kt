package com.flasshka.aist.domain.entities

enum class ChatModel {
    GIGACHAT, YANDEX_GPT;

    override fun toString(): String {
        return when(this) {
            GIGACHAT -> "GigaChat"
            YANDEX_GPT -> "Yandex GPT"
        }
    }
}