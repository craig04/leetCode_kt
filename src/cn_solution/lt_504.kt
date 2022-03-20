package cn_solution

fun convertToBase7(num: Int): String {
    val c = arrayListOf<Char>()
    var temp = Math.abs(num)
    do {
        c.add('0' + (temp % 7))
        temp /= 7
    } while (temp != 0)
    return c.asReversed().joinToString("", if (num < 0) "-" else "")
}