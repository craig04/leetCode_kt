package cn_solution

fun winningPlayerCount(n: Int, pick: Array<IntArray>): Int {
    val cnt = Array(n) { IntArray(11) }
    val win = BooleanArray(n)
    for ((x, y) in pick)
        if (++cnt[x][y] > x)
            win[x] = true
    return win.count { it }
}
