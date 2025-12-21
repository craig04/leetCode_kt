package cn_solution

fun minAllOneMultiple(k: Int): Int {
    if (k % 2 == 0 || k % 5 == 0)
        return -1
    var mod = 0
    repeat(k) {
        mod = (mod * 10 + 1) % k
        if (mod == 0)
            return it + 1
    }
    return -1
}