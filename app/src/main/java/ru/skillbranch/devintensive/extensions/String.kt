package ru.skillbranch.devintensive.extensions

fun String.truncate(value:Int=16):String{
    var text =this.trimEnd()
    if (value<text.length) {
        text = text.dropLast(text.length - value)
        if (text.get(value-1)== ' ') {
            text=text.dropLast(1)
        }
        text += "..."
    }
   // this.replace(this, text)
    return text
}

fun String.stripHtml():String{
    TODO()
}