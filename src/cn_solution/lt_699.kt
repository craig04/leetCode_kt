package cn_solution

fun fallingSquares(positions: Array<IntArray>): List<Int> {

    class Node {
        var low = 0
        var high = 0
        var data = 0
    }

    val set = HashSet<Int>()
    for ((left, len) in positions) {
        set.add(left)
        set.add(left + len)
    }
    val a = set.toIntArray()
    a.sort()
    val map = a.indices.associateBy { a[it] }
    val nodes = Array(a.size * 4) { Node() }
    fun init(i: Int, low: Int, high: Int) {
        val node = nodes[i]
        node.low = low
        node.high = high
        if (low != high) {
            val mid = (low + high) shr 1
            val left = i * 2 + 1
            val right = left + 1
            init(left, low, mid)
            init(right, mid + 1, high)
        }
    }

    fun query(i: Int, low: Int, high: Int): Int {
        val node = nodes[i]
        if (node.low == node.high)
            return node.data
        var ans = 0
        val mid = (node.low + node.high) shr 1
        if (low <= mid)
            ans = maxOf(ans, query(i * 2 + 1, low, minOf(high, mid)))
        if (high > mid)
            ans = maxOf(ans, query(i * 2 + 2, maxOf(low, mid + 1), high))
        return ans
    }

    fun update(i: Int, low: Int, high: Int, data: Int) {
        val it = nodes[i]
        it.data = maxOf(it.data, data)
        if (it.low == it.high)
            return
        val mid = (it.low + it.high) shr 1
        if (low <= mid)
            update(i * 2 + 1, low, minOf(mid, high), data)
        if (high > mid)
            update(i * 2 + 2, maxOf(low, mid + 1), high, data)
    }
    init(0, 0, a.size - 2)
    var highest = 0
    return positions.map { (left, len) ->
        val low = map[left] ?: 0
        val high = (map[left + len] ?: 1) - 1
        val height = query(0, low, high) + len
        update(0, low, high, height)
        highest = maxOf(highest, height)
        highest
    }
}