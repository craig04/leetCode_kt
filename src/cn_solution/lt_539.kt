package cn_solution

private const val MINUTES = 1440

fun findMinDifference(timePoints: List<String>): Int {
    if (timePoints.size > MINUTES) {
        return 0
    }
    fun String.int(from: Int, to: Int) = substring(from, to).toInt()
    val list = timePoints
        .asSequence()
        .map { it.int(0, 2) * 60 + it.int(3, 5) }
        .sorted()
        .toList()
    return (1 until list.size).fold(MINUTES + list[0] - list.last()) { diff, i ->
        minOf(diff, list[i] - list[i - 1])
    }
}