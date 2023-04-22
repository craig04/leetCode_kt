package cn_solution

fun minHeightShelves(books: Array<IntArray>, shelfWidth: Int): Int {
    val n = books.size
    val dp = IntArray(n + 1)
    for (i in books.indices.reversed()) {
        dp[i] = Int.MAX_VALUE
        var length = 0
        var height = 0
        for (j in i until n) {
            length += books[j][0]
            if (length > shelfWidth)
                break
            height = maxOf(height, books[j][1])
            dp[i] = minOf(dp[i], height + dp[j + 1])
        }
    }
    return dp[0]
}