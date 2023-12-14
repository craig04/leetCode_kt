package cn_solution

fun minimumEffort(tasks: Array<IntArray>): Int {
    tasks.sortBy { it[1] - it[0] }
    return tasks.fold(0) { res, t -> maxOf(res + t[0], t[1]) }
}