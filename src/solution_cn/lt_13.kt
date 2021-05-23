package solution_cn

fun romanToInt(s: String): Int {
    val value = arrayOf(0, 0, 100, 500, 0, 0, 0, 0, 1, 0, 0,
            50, 1000, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10, 0, 0)

    fun Char.roman() = value[this - 'A']
    var last = s[0].roman()
    var result = 0
    for (i in 1 until s.length) {
        val cur = s[i].roman()
        result += if (last >= cur) last else -last
        last = cur
    }
    return result + s.last().roman()
}