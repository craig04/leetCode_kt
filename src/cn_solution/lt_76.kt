package cn_solution

fun minWindow(s: String, t: String): String {
    val times = IntArray(60)
    var count = 0
    t.forEach { if (++times[it - 'A'] == 1) count++ }

    var left = 0
    var right = Int.MAX_VALUE
    var i = 0
    s.forEachIndexed { j, c ->
        if (--times[c - 'A'] == 0)
            count--
        while (count == 0 && times[s[i] - 'A'] < 0)
            times[s[i++] - 'A']++
        if (count == 0 && j - i < right - left) {
            left = i
            right = j
        }
    }
    return if (right == Int.MAX_VALUE) "" else s.substring(left, right + 1)
}