package cn_solution

fun relocateMarbles(nums: IntArray, moveFrom: IntArray, moveTo: IntArray): List<Int> {
    val map = HashMap<Int, Int>()
    for (pos in nums)
        map.merge(pos, 1) { a, b -> a + b }
    for (i in moveFrom.indices) {
        map.remove(moveFrom[i])?.let {
            map.merge(moveTo[i], it) { a, b -> a + b }
        }
    }
    return map.keys.sorted()
}