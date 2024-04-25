package cn_solution

fun numberOfWeeks(milestones: IntArray): Long {
    var sum = 0L
    var max = 0
    for (m in milestones) {
        sum += m
        max = maxOf(max, m)
    }
    return if (max * 2L > sum) (sum - max) * 2 + 1 else sum
}