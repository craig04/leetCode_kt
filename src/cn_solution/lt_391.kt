package cn_solution

fun isRectangleCover(rectangles: Array<IntArray>): Boolean {
    fun hash(x: Int, y: Int) = x * 200001L + y
    val map = HashMap<Long, Int>()
    for ((x, y, a, b) in rectangles) {
        fun add(x: Int, y: Int, cnt: Int) =
            map.merge(hash(x, y), cnt) { a, b ->
                if (a + b == 0) null else a + b
            }
        add(x, y, 1)
        add(x, b, -1)
        add(a, y, -1)
        add(a, b, 1)
    }
    return map.size == 4 && map.minBy { it.key }.value == 1
}