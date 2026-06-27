package cn_solution

fun minimumOneBitOperations(n: Int): Int {
    var ans = 0
    var x = n
    while (x != 0) {
        val t = x.takeLowestOneBit()
        ans = t * 2 - 1 - ans
        x -= t
    }
    return ans
}