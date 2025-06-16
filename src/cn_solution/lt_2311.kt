package cn_solution

fun longestSubsequence(s: String, k: Int): Int {
    var sum = 0
    var ans = 0
    for (i in s.indices) {
        if (s[s.lastIndex - i] == '1') {
            if (i <= 30 && 1.shl(i) + sum <= k) {
                sum += 1.shl(i)
                ans++
            }
        } else
            ans++
    }
    return ans
}