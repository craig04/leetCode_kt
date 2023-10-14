package cn_solution

fun countPoints(rings: String): Int {
    fun Char.bit() = 1.shl(this - 'A')
    val s = IntArray(10)
    for (i in rings.indices step 2) {
        val t = rings[i + 1] - '0'
        s[t] = s[t] or rings[i].bit()
    }
    val target = 'R'.bit() or 'G'.bit() or 'B'.bit()
    return s.count { it == target }
}