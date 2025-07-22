package cn_solution

private fun earliestFinishTime(
    landStartTime: IntArray,
    landDuration: IntArray,
    waterStartTime: IntArray,
    waterDuration: IntArray
): Int {
    val land = landStartTime.indices.minOf { landStartTime[it] + landDuration[it] }
    val water = waterStartTime.indices.minOf { waterStartTime[it] + waterDuration[it] }
    return minOf(
        landStartTime.indices.minOf { maxOf(landStartTime[it], water) + landDuration[it] },
        waterStartTime.indices.minOf { maxOf(waterStartTime[it], land) + waterDuration[it] }
    )
}