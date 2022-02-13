package cn_solution

fun intToRoman(num: Int): String {
    val map = arrayOf(
            arrayOf("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"),
            arrayOf("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"),
            arrayOf("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "DC"),
            arrayOf("", "M", "MM", "MMM"))

    fun transform(num: Int, level: Int): String =
            if (num == 0) "" else transform(num / 10, level + 1) + map[level][num % 10]
    return transform(num, 0)
}