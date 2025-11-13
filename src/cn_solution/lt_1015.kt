package cn_solution

fun smallestRepunitDivByK(k: Int): Int {
    if (k % 2 == 0 || k % 5 == 0)
        return -1
    val set = HashSet<Int>()
    var rem = 0
    while (set.size < k) {
        rem = (rem * 10 + 1) % k
        if (rem == 0)
            return set.size + 1
        if (!set.add(rem))
            break
    }
    return -1
}