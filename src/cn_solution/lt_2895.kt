package cn_solution

fun minProcessingTime(processorTime: List<Int>, tasks: List<Int>): Int {
    val p = processorTime.sorted()
    val t = tasks.sortedDescending()
    return p.indices.maxOf { p[it] + t[it * 4] }
}