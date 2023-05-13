package cn_solution

fun getSmallestString(n: Int, k: Int): String {
    return buildString {
        var left = k
        for (i in n - 1 downTo 0) {
            val cur = maxOf(1, left - i * 26)
            append('a' + cur - 1)
            left -= cur
        }
    }
}