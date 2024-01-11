package cn_solution

fun repeatLimitedString(s: String, repeatLimit: Int): String {
    val cnt = IntArray(26)
    s.forEach { cnt[it - 'a']++ }
    val sb = StringBuilder()
    fun next(i: Int): Int = (i - 1 downTo 0).firstOrNull { cnt[it] != 0 } ?: -1
    var i = next(cnt.size)
    var j = next(i)
    while (i != -1) {
        val n = minOf(repeatLimit, cnt[i])
        repeat(n) { sb.append('a' + i) }
        cnt[i] -= n
        if (j == -1)
            break
        if (cnt[i] == 0) {
            i = j
            j = next(i)
        } else {
            sb.append('a' + j)
            if (--cnt[j] == 0)
                j = next(i)
        }
    }
    return sb.toString()
}