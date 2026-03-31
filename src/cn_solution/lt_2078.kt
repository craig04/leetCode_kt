package cn_solution

fun maxDistance(colors: IntArray): Int {
    val map = HashMap<Int, Int>()
    var ans = 0
    for (i in colors.indices) {
        val color = colors[i]
        ans = maxOf(ans, map.maxOfOrNull { (k, v) -> if (k == color) 0 else i - v } ?: 0)
        if (map.size < 2)
            map.putIfAbsent(color, i)
    }
    return ans
}