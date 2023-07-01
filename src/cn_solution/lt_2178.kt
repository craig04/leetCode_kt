package cn_solution

fun maximumEvenSplit(finalSum: Long): List<Long> {
    if (finalSum and 1L != 0L) {
        return emptyList()
    }
    var base = 2L
    var sum = 0L
    val result = ArrayList<Long>()
    while (sum + base <= finalSum) {
        result.add(base)
        sum += base
        base += 2
    }
    result[result.lastIndex] += finalSum - sum
    return result
}