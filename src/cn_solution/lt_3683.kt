package cn_solution

fun earliestTime(tasks: Array<IntArray>): Int {
    return tasks.minOf { it[0] + it[1] }
}