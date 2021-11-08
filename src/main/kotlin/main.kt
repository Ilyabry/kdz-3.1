fun main() {
    val time = agoToText(123)
    println("Был $time")
}
fun agoToText(seconds: Int): String =
    when(seconds) {
        in 0..60 -> "только что"
        in 61..3599 -> Minutes(seconds/60)
        in 3600..3600*24 -> Hours(seconds/3600)
        in 3600*24+1..3600*48 -> "сегодня"
        in 3600*48+1..3600*72 -> "вчера"
        else -> "давно"
    }
fun Minutes(minute: Int): String =
    when{
        minute in 11..14 -> "$minute минут назад"
        minute%10 == 1 -> "$minute минуту назад"
        minute%10 in 2..4 -> "$minute минуты назад"
        else -> "$minute минут назад"
    }
fun Hours(hour: Int): String =
    when(hour){
        1,21 -> "$hour час назад"
        in 2..4, in 22..24 ->"$hour часа назад"
        else -> "$hour часов назад"
    }