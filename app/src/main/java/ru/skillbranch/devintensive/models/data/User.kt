package ru.skillbranch.devintensive.models.data

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User (
    val id : String,
    var firstName : String?,
    var lastName : String?,
    var avatar : String?,
    var rating : Int = 0,
    var respect : Int = 0,
    var lastVisit : Date? = Date(),
    var isOnline : Boolean = false
){

    constructor(id:String,firstName: String?, lastName: String?):this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    constructor (builder: Builder):this(
        id = builder.id,
        firstName = builder.firstName,
        lastName = builder.lastName,
        avatar = builder.avatar,
        rating = builder.rating,
        respect = builder.respect,
        lastVisit = builder.lastVisit,
        isOnline = builder.isOnline
    )

    data class Builder(
        var id : String = "",
        var firstName : String? = "",
        var lastName : String? = "",
        var avatar : String? = "",
        var rating : Int = 0,
        var respect : Int = 0,
        var lastVisit : Date? = Date(),
        var isOnline : Boolean = false
    ){

        fun id(value:String)= apply { this.id=value }

        fun firstName(value:String?) = apply { this.firstName=value}

        fun lastName(value:String?) = apply { this.lastName=value}

        fun avatar(value:String?) = apply { this.avatar=value }

        fun rating(value:Int)= apply { this.rating = value
}

        fun respect (value:Int)= apply { this.respect = value }

        fun lastVisit(value:Date?)= apply { this.lastVisit = value }

        fun isOnline(value:Boolean)= apply { this.isOnline = value }

        fun build(): User =
            User(this)

    }

    companion object Factory{
        private var lastId: Int = -1;
        fun makeUser(fullName:String): User {
            lastId++
            val (firstName,lastName) = Utils.parseFullName(fullName)
            return User(
                "$lastId",
                firstName,
                lastName
            )
        }
    }
}