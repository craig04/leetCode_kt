package cn_interview

fun canPermutePalindrome(s: String): Boolean {
    val map = HashMap<Char, Int>()
    s.forEach { map[it] = (map[it] ?: 0) + 1 }
    return map.count { it.value and 1 == 1 } <= 1
}