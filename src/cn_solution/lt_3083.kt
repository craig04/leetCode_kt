package cn_solution

fun isSubstringPresent(s: String): Boolean {
    val vis = BooleanArray(26 * 26)
    return (0 until s.length - 1).any {
        val a = s[it] - 'a'
        val b = s[it + 1] - 'a'
        vis[a * 26 + b] = true
        vis[b * 26 + a]
    }
}