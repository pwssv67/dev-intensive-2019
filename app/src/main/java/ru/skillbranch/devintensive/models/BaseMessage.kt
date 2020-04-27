package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.models.data.Chat
import ru.skillbranch.devintensive.models.data.User
import java.util.*

abstract class BaseMessage(
    val id: String,
    val from: User?,
    val chat: Chat,
    val isIncoming: Boolean = false,
    val date: Date = Date()
) {
    abstract fun formatMessage():String
    companion object AbstractFactory{
        private var lastId:Int = -1
        fun makeMessage(from: User?,
                        chat: Chat,
                        date:Date = Date(),
                        type: String ="text",
                        payload:Any?,
                        isIncoming:Boolean = false) : BaseMessage
        {
            lastId++
            return when (type) {
                "image", "Image", "IMAGE" -> ImageMessage("$lastId", from, chat,isIncoming,  date= date, image = payload as String)
                else -> TextMessage("$lastId", from, chat,isIncoming, date= date,readen = false,text= payload as String)
            }
        }
    }
}