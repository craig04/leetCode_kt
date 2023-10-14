package cn_solution

fun earliestFullBloom(plantTime: IntArray, growTime: IntArray): Int {
    val indices = growTime.indices.sortedByDescending { growTime[it] }
    var start = 0
    return plantTime.indices.maxOf {
        val index = indices[it]
        start += plantTime[index]
        start + growTime[index]
    }
}