package cn_solution

fun generateSchedule(n: Int): Array<IntArray> {
    if (n < 5)
        return emptyArray()
    val ans = Array(n * (n - 1)) { IntArray(2) }
    var idx = 0
    fun write(x: Int, y: Int) {
        ans[idx][0] = x
        ans[idx++][1] = y
    }
    for (d in 2 until n - 1)
        for (i in 0 until n)
            write(i, (i + d) % n)
    for (i in 0 until n) {
        write(i, (i + 1) % n)
        write((i + n - 1) % n, (i + n - 2) % n)
    }
    return ans
}