package cn_solution

fun hammingWeight(n: Int): Int {
    var bits = 0
    var t = n
    while (t != 0) {
        bits++
        t = t and t - 1
    }
    return bits
}