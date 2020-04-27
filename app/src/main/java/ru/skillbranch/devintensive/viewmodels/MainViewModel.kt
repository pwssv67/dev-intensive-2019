package ru.skillbranch.devintensive.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.skillbranch.devintensive.extensions.mutableLiveData
import ru.skillbranch.devintensive.models.data.ChatItem
import ru.skillbranch.devintensive.repositories.ChatRepository

class MainViewModel:ViewModel() {
    private val chatRepository = ChatRepository
    private val chats = mutableLiveData(loadChats())

    fun getChatData():LiveData<List<ChatItem>> {
        return MutableLiveData(loadChats())
    }

    private fun loadChats():List<ChatItem> {
        val chats = chatRepository.loadChats()
        return chats.map{ it.toChatItem()}
            .sortedBy { it.id.toInt() }
    }

    fun addItems() {
        TODO("Not yet implemented")
    }
}