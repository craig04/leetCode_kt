package cn_offer

fun firstUniqChar(s: String): Char {
    val map = HashMap<Char, Int>()
    s.forEach { map[it] = (map[it] ?: 0) + 1 }
    return s.firstOrNull { map[it] == 1 } ?: ' '
}