package cn_solution

fun countStudents(students: IntArray, sandwiches: IntArray): Int {
    val cnt = IntArray(2)
    for (s in students)
        cnt[s]++
    for (i in sandwiches.indices)
        if (--cnt[sandwiches[i]] == -1)
            return sandwiches.size - i
    return 0
}