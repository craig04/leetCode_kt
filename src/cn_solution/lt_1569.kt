package cn_solution

fun numOfWays(nums: IntArray): Int {
    val n = nums.size
    val prev = IntArray(n + 2) { it - 1 }
    val next = IntArray(n + 2) { it + 1 }
    val size = IntArray(n + 2)
    var num = 1L
    var den = 1L
    val modulo = 1000000007
    for (i in nums.indices.reversed()) {
        val x = nums[i]
        size[x] = 1
        var y = prev[x]
        if (size[y] != 0) {
            size[x] += size[y]
            val z = prev[y]
            next[z] = x
            prev[x] = z
        }
        y = next[x]
        if (size[y] != 0) {
            size[x] += size[y]
            val z = next[y]
            next[x] = z
            prev[z] = x
        }
        num = num * x % modulo
        den = den * size[x] % modulo
    }
    var pow = modulo - 2
    var mul = 1L
    while (pow != 0) {
        if (pow and 1 != 0)
            mul = mul * den % modulo
        den = den * den % modulo
        pow = pow shr 1
    }
    return (num * mul - 1 + modulo).mod(modulo)
}