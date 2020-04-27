package ru.skillbranch.devintensive.models.data

import ru.skillbranch.devintensive.extensions.shortFormat
import ru.skillbranch.devintensive.models.BaseMessage
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

class Chat(
    val id: String,
    val title: String,
    val members: List<User> = listOf(),
    var messages: MutableList<BaseMessage> = mutableListOf(),
    var isArchived:Boolean = false
) {
    private fun lastMessageDate(): Date?{
        //TODO
        return Date()
    }

    private fun lastMessageShort(): String{
        //TODO
        return "Сообщений ещё нет"
    }

    fun unreadableMessageCount():Int {
        //TODO
        return 0
    }

    private fun isSingle():Boolean = members.size == 1

    fun toChatItem():ChatItem {
        return if (isSingle()) {
            val user = members.first()
            ChatItem(
                id,
                user.avatar,
                Utils.toInitials(user.firstName, user.lastName)?:"??",
                "${user.firstName?:""} ${user.lastName?:""}",
                lastMessageShort(),
                unreadableMessageCount(),
                lastMessageDate()?.shortFormat(),
                user.isOnline
            )
        } else{
            val user = members.first()
            ChatItem(
                id,
                null,
                "",
                title,
                lastMessageShort(),
                unreadableMessageCount(),
                lastMessageDate()?.shortFormat(),
                false
            )
        }
    }
}