package cn_solution

fun maxSubstrings(word: String): Int {
    val n = word.length
    var ans = 0
    var bit = 0
    var i = 3
    while (i < n) {
        bit = 1 shl (word[i - 3] - 'a') or bit
        if (1 shl (word[i] - 'a') and bit != 0) {
            ans++
            bit = 0
            i += 3
        }
        i++
    }
    return ans
}