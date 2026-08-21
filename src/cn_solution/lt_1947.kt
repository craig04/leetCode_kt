package cn_solution

fun maxCompatibilitySum(students: Array<IntArray>, mentors: Array<IntArray>): Int {
    val n = students.size
    val c = Array(n) { IntArray(n) }
    students.forEachIndexed { i, s ->
        mentors.forEachIndexed { j, m ->
            c[i][j] = s.indices.count { s[it] == m[it] }
        }
    }
    val dp = Array(n + 1) { IntArray(1 shl n) }
    for (i in 1..n)
        for (x in dp[i].indices)
            if (x.countOneBits() == i)
                for (j in 0 until n) {
                    val y = 1 shl j xor x
                    if (y < x)
                        dp[i][x] = maxOf(dp[i][x], dp[i - 1][y] + c[i - 1][j])
                }
    return dp[n].max()
}