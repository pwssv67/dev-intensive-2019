package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extensions.humanizeDiff
import java.util.*

class ImageMessage(id: String,
                   from: User?,
                   chat: Chat,
                   isIncoming: Boolean,
                   date: Date,
                   var image:String?
) : BaseMessage(id, from, chat, isIncoming, date) {
    override fun formatMessage(): String {
        return "$from  ${if (isIncoming) "получил" else "отправил"} сообщение \"$image\" ${date.humanizeDiff()}"
    }

}