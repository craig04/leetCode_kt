package cn_solution

fun doesAliceWin(s: String): Boolean {
    val f = BooleanArray(26)
    "aeiou".forEach { f[it - 'a'] = true }
    return s.any { f[it - 'a' ]}
}