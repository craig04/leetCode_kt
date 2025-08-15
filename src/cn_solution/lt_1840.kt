package cn_solution

fun maxBuilding(n: Int, restrictions: Array<IntArray>): Int {
    restrictions.sortBy { it[0] }
    val h = IntArray(restrictions.size)
    var opt = -1
    restrictions.forEachIndexed { i, (id, height) ->
        opt = minOf(opt, height - id)
        h[i] = id + opt
    }
    opt = Int.MAX_VALUE
    for (i in restrictions.indices.reversed()) {
        val (id, height) = restrictions[i]
        opt = minOf(opt, height + id)
        h[i] = minOf(h[i], opt - id)
    }
    var ans = 0
    var x = 1
    var pre = 0
    for (i in h.indices) {
        val y = restrictions[i][0]
        val cur = h[i]
        ans = maxOf(ans, (pre + cur + y - x) / 2)
        x = y
        pre = cur
    }
    return maxOf(ans, pre + n - x)
}