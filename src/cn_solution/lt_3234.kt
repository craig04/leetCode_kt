package cn_solution

fun numberOfSubstrings(s: String): Int {
    var ans = 0
    var cnt0 = 0
    var cnt1 = 0
    val prev = arrayListOf(0)
    for (c in s) {
        if (c == '1')
            cnt1++
        else
            cnt0++
        for (remove0 in minOf(cnt0, prev.lastIndex) downTo 0) {
            val remain0 = cnt0 - remove0
            if (remain0 * remain0 > cnt1)
                break
            val min = if (remove0 == 0) 0 else prev[remove0 - 1]
            val max = prev[remove0]
            ans += maxOf(0, minOf(max, cnt1 - remain0 * remain0) - min + 1)
        }
        if (prev.lastIndex != cnt0)
            prev.add(0)
        prev[cnt0] = cnt1
    }
    return ans
}