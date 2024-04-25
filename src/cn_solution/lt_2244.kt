package cn_solution

fun minimumRounds(tasks: IntArray): Int {
    return tasks.asSequence().groupingBy { it }.eachCount().entries.sumOf {
        if (it.value == 1)
            return -1
        (it.value + 2) / 3
    }
}