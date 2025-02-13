package cn_solution

fun largestOverlap(img1: Array<IntArray>, img2: Array<IntArray>): Int {
    val n = img1.size
    val cnt = Array(2 * n - 1) { IntArray(2 * n - 1) }
    for (i in 0 until n)
        for (j in 0 until n)
            if (img1[i][j] == 1)
                for (x in 0 until n)
                    for (y in 0 until n)
                        if (img2[x][y] == 1)
                            cnt[i - x + n - 1][j - y + n - 1]++
    return cnt.maxOf { it.max() }
}