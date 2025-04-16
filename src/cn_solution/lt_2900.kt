package cn_solution

fun getLongestSubsequence(words: Array<String>, groups: IntArray): List<String> {
    val ans = ArrayList<String>()
    for (i in words.indices)
        if (i == 0 || groups[i] != groups[i - 1])
            ans += words[i]
    return ans
}