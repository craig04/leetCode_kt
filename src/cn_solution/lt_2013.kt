package cn_solution

class DetectSquares() {

    val rows = Array(1001) { HashMap<Int, Int>() }

    fun add(point: IntArray) {
        val (x, y) = point
        rows[y].merge(x, 1, Int::plus)
    }

    fun count(point: IntArray): Int {
        var ans = 0
        val (x, y) = point
        for ((a, n) in rows[y]) {
            if (a == x)
                continue
            val len = a - x
            if (y + len in rows.indices) {
                val map = rows[y + len]
                ans += n * map.getOrDefault(x, 0) * map.getOrDefault(a, 0)
            }
            if (y - len in rows.indices) {
                val map = rows[y - len]
                ans += n * map.getOrDefault(x, 0) * map.getOrDefault(a, 0)
            }
        }
        return ans
    }
}