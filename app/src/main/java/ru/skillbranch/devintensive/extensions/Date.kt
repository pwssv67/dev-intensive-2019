package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000
const val MINUTE = 60* SECOND
const val HOUR = 60* MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern:String = "HH:mm:ss dd.MM.yy"):String{
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.shortFormat():String?{
    val pattern = if (this.isSameDay(Date())) "HH:mm" else "dd.MM.yy"
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return  dateFormat.format(this)
}

fun Date.isSameDay(date:Date):Boolean{
    val day1 = this.time/ DAY
    val day2 = date.time/ DAY
    return day1 == day2
}

fun Date.add(value:Int, units:TimeUnits = TimeUnits.SECOND):Date{
    var time = this.time
    time += when(units) {
        TimeUnits.SECOND -> value*SECOND
        TimeUnits.MINUTE -> value* MINUTE
        TimeUnits.HOUR -> value* HOUR
        TimeUnits.DAY -> value* DAY
    }
    this.time = time
    return this
}

fun Date.humanizeDiff(date:Date=Date()):String {
    val timeDiff:Long = Date().time - this.time

    return when (timeDiff) {
        in 0..1*SECOND -> "только что"
        in 1*SECOND..45* SECOND ->"несколько секунд назад"
        in 45*SECOND..75*SECOND-> "минуту назад"
        in 75*SECOND..45* MINUTE-> {
            when (timeDiff) {
                in 1* MINUTE..4* MINUTE ->"${timeDiff/ MINUTE +1} минуты назад"
                in 4* MINUTE..20* MINUTE-> "${timeDiff/ MINUTE +1} минут назад"
                else -> {
                    when (timeDiff%10) {
                        in 0 * MINUTE..1 * MINUTE -> "${timeDiff/ MINUTE +1} минуту назад"
                        in 1 * MINUTE..4 * MINUTE -> "${timeDiff/ MINUTE +1} минуты назад"
                        in 4 * MINUTE..20 * MINUTE -> "${timeDiff/ MINUTE +1} минут назад"
                        else -> ""
                    }
                }
            }
        }
        in 45* MINUTE..75*MINUTE-> "час назад"
        in 75*MINUTE..22* HOUR-> when (timeDiff) {
            in 1* HOUR..4* HOUR ->"${timeDiff/ HOUR +1} часа назад"
            in 4* HOUR..20* HOUR-> "${timeDiff/ HOUR +1} часов назад"
            else -> {
                when (timeDiff%10) {
                    in 0 * HOUR..1 * HOUR-> "${timeDiff/ HOUR +1} час назад"
                    in 1 * HOUR..4 * HOUR -> "${timeDiff/ HOUR +1} часа назад"
                    in 4 * HOUR..20 * HOUR-> "${timeDiff/ HOUR +1} часов назад"
                    else -> ""
                }
            }
        }
        in 22* HOUR..26*HOUR-> "день назад"
        in 26*HOUR..360*DAY-> when (timeDiff) {
            in 1* DAY..4* DAY ->"${timeDiff/ DAY +1} дня назад"
            in 4* DAY..20* DAY-> "${timeDiff/ DAY +1} дней назад"
            else -> {
                when (timeDiff%10) {
                    in 0 * DAY..1 * DAY-> "${timeDiff/ DAY +1} день назад"
                    in 1 * DAY..4 * DAY-> "${timeDiff/ DAY +1} дня назад"
                    in 4 * DAY..20 * DAY -> "${timeDiff/ DAY} +1 дней назад"
                    else -> ""
                }
            }
        }
        else -> "более года назад"
    }
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}