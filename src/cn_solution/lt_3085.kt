package cn_solution

fun minimumDeletions(word: String, k: Int): Int {
    val cnt = IntArray(26)
    for (c in word)
        cnt[c - 'a']++
    return cnt.minOf { low ->
        cnt.sumOf { cur ->
            when {
                cur < low -> cur
                cur < low + k -> 0
                else -> cur - low - k
            }
        }
    }
}