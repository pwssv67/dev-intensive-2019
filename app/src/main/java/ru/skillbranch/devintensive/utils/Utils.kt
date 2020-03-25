package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String):Pair<String?,String?> {
        val parts : List<String>? = fullName.split(" ")
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(0)
        return firstName to lastName
    }

    fun toInitials(firstName:String?, lastName:String?):String? {
        var initials:String?=null
        return when {
            firstName.isNullOrEmpty() && lastName.isNullOrEmpty() ->  null
            firstName.isNullOrEmpty() && !lastName.isNullOrEmpty() -> "${lastName.get(0).toUpperCase()}"
            !firstName.isNullOrEmpty() && lastName.isNullOrEmpty() -> "${firstName.get(0).toUpperCase()}"
            else -> "${firstName?.get(0)?.toUpperCase()}${lastName?.get(0)?.toUpperCase()}"

        }
    }

    fun transliteration(payload:String, divider:String=" "):String{
        var transliterated:String=""
        for (symbol in payload) {
            transliterated += when (symbol) {
                'а'-> "a"
                'б'-> "b"
                'в'-> "v"
                'г'-> "g"
                'д'-> "d"
                'е'-> "e"
                'ё'-> "e"
                'ж'-> "zh"
                'з'-> "z"
                'и'-> "i"
                'й'-> "i"
                'к'-> "k"
                'л'-> "l"
                'м'-> "m"
                'н'-> "n"
                'о'-> "o"
                'п'-> "p"
                'р'-> "r"
                'с'-> "s"
                'т'-> "t"
                'у'-> "u"
                'ф'-> "f"
                'х'-> "h"
                'ц'-> "c"
                'ч'-> "ch"
                'ш'-> "sh"
                'щ'-> "sh'"
                'ъ'-> ""
                'ы'-> "i"
                'ь'-> ""
                'э'-> "e"
                'ю'-> "yu"
                'я'-> "ya"
                'а'.toUpperCase()-> "a".toUpperCase()
                'б'.toUpperCase()-> "b".toUpperCase()
                'в'.toUpperCase()-> "v".toUpperCase()
                'г'.toUpperCase()-> "g".toUpperCase()
                'д'.toUpperCase()-> "d".toUpperCase()
                'е'.toUpperCase()-> "e".toUpperCase()
                'ё'.toUpperCase()-> "e".toUpperCase()
                'ж'.toUpperCase()-> "Zh"
                'з'.toUpperCase()-> "z".toUpperCase()
                'и'.toUpperCase()-> "i".toUpperCase()
                'й'.toUpperCase()-> "i".toUpperCase()
                'к'.toUpperCase()-> "k".toUpperCase()
                'л'.toUpperCase()-> "l".toUpperCase()
                'м'.toUpperCase()-> "m".toUpperCase()
                'н'.toUpperCase()-> "n".toUpperCase()
                'о'.toUpperCase()-> "o".toUpperCase()
                'п'.toUpperCase()-> "p".toUpperCase()
                'р'.toUpperCase()-> "r".toUpperCase()
                'с'.toUpperCase()-> "s".toUpperCase()
                'т'.toUpperCase()-> "t".toUpperCase()
                'у'.toUpperCase()-> "u".toUpperCase()
                'ф'.toUpperCase()-> "f".toUpperCase()
                'х'.toUpperCase()-> "h".toUpperCase()
                'ц'.toUpperCase()-> "c".toUpperCase()
                'ч'.toUpperCase()-> "Ch"
                'ш'.toUpperCase()-> "Sh"
                'щ'.toUpperCase()-> "Sh'"
                'ъ'.toUpperCase()-> "".toUpperCase()
                'ы'.toUpperCase()-> "i".toUpperCase()
                'ь'.toUpperCase()-> "".toUpperCase()
                'э'.toUpperCase()-> "e".toUpperCase()
                'ю'.toUpperCase()-> "Yu"
                'я'.toUpperCase()-> "Ya"
                ' ' -> divider
                else -> symbol
            }
        }
        return transliterated
    }
}