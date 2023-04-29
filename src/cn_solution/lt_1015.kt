package cn_solution

fun smallestRepunitDivByK(k: Int): Int {
    if (k % 2 == 0 || k % 5 == 0)
        return -1
    val set = HashSet<Int>()
    var remainder = 0
    var result = 0
    while (true) {
        result++
        remainder = (remainder * 10 + 1) % k
        if (remainder == 0)
            break
        if (!set.add(remainder))
            return -1
    }
    return result
}