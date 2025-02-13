package cn_solution

fun findTheLongestSubstring(s: String): Int {
    val idx = IntArray(26) { -1 }
    "aeiou".forEachIndexed { i, c -> idx[c - 'a'] = i }
    val pos = IntArray(32) { -2 }
    pos[0] = -1
    var bit = 0
    var ans = 0
    for (i in s.indices) {
        val j = idx[s[i] - 'a']
        if (j >= 0)
            bit = 1.shl(j) xor bit
        if (pos[bit] == -2)
            pos[bit] = i
        else
            ans = maxOf(ans, i - pos[bit])
    }
    return ans
}