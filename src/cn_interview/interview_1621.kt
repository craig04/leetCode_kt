package cn_interview

fun findSwapValues(array1: IntArray, array2: IntArray): IntArray {
    var sum = -array2.sum()
    val set = HashSet<Int>()
    array1.forEach {
        sum += it
        set.add(it)
    }
    if (sum and 1 == 1)
        return intArrayOf()
    for (m in array2) {
        val n = m + sum / 2
        if (n in set)
            return intArrayOf(n, m)
    }
    return intArrayOf()
}