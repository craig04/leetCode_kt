package cn_solution

fun createSortedArray(instructions: IntArray): Int {
    val n = 100000
    val a = IntArray(n + 1)
    fun add(x: Int) {
        var y = x
        while (y <= n) {
            a[y]++
            y += y.takeLowestOneBit()
        }
    }

    fun query(x: Int): Int {
        var res = 0
        var y = x
        while (y > 0) {
            res += a[y]
            y = y and (y - 1)
        }
        return res
    }

    var ans = 0
    for (x in instructions) {
        val cost = minOf(query(n) - query(x), query(x - 1))
        ans = (ans + cost) % 1000000007
        add(x)
    }
    return ans
}