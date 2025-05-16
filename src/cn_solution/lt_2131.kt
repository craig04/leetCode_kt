package cn_solution

fun longestPalindrome(words: Array<String>): Int {
    val cnt = Array(26) { IntArray(26) }
    for (word in words) {
        val a = word[0] - 'a'
        val b = word[1] - 'a'
        cnt[a][b]++
    }
    var ans = 0
    var odd = 0
    for (i in 0 until 26) {
        ans += cnt[i][i] and -2
        odd = cnt[i][i] and 1 or odd
        for (j in i + 1 until 26)
            ans += minOf(cnt[i][j], cnt[j][i]) * 2
    }
    return (ans + odd) * 2
}