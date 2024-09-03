package cn_solution

private fun maximumValueSum(board: Array<IntArray>): Long {

    fun swap(a: IntArray, i: Int, j: Int) {
        a[i] = a[i] xor a[j]
        a[j] = a[i] xor a[j]
        a[i] = a[i] xor a[j]
    }

    fun update(a: IntArray, j: Int, s: Int) {
        if (s <= a[1])
            return
        a[0] = j
        a[1] = s
        if (a[1] > a[3]) {
            swap(a, 0, 2)
            swap(a, 1, 3)
        }
        if (a[3] > a[5]) {
            swap(a, 2, 4)
            swap(a, 3, 5)
        }
    }

    val n = board.size
    val m = board.first().size
    val suf = Array(n) { IntArray(6) { Int.MIN_VALUE } }
    val max = IntArray(m) { Int.MIN_VALUE }
    for (i in n - 1 downTo 1) {
        val a = board[i]
        for (j in a.indices) {
            max[j] = maxOf(max[j], a[j])
            update(suf[i], j, max[j])
        }
    }
    var ans = Long.MIN_VALUE
    val pre = Array(n) { IntArray(6) { Int.MIN_VALUE } }
    max.fill(Int.MIN_VALUE)
    for (i in 1 until n - 1) {
        var a = board[i - 1]
        for (j in a.indices) {
            max[j] = maxOf(max[j], a[j])
            update(pre[i - 1], j, max[j])
        }
        a = board[i]
        for (j in a.indices) {
            for (x in pre[i - 1].indices.step(2))
                for (y in suf[i + 1].indices.step(2)) {
                    val u = pre[i - 1][x]
                    val v = suf[i + 1][y]
                    if (u == v || u == j || v == j)
                        continue
                    ans = maxOf(ans, 0L + a[j] + pre[i - 1][x + 1] + suf[i + 1][y + 1])
                }
        }
    }
    return ans
}