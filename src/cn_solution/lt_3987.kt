package cn_solution

fun minimumCost(nums: IntArray, k: Int): Int {
    var res = k
    var cnt = 0L
    for (num in nums) {
        if (res < num) {
            val x = (num - res - 1) / k + 1
            cnt += x
            res += x * k
        }
        res -= num
    }
    val modulo = 1000000007
    cnt %= modulo
    return ((1 + cnt) * cnt / 2).mod(modulo)
}