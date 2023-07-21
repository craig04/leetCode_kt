package cn_solution

private const val MOD = 1000000007L

fun sumOfPower(nums: IntArray): Int {
    nums.sort()
    var sum1 = 0L
    var sum2 = 0L
    var temp = 0L
    for (n in nums) {
        val m = (n.toLong() * n) % MOD
        sum1 = (sum1 + m * temp) % MOD
        sum2 = (sum2 + m * n) % MOD
        temp = (temp * 2 + n) % MOD
    }
    return ((sum1 + sum2) % MOD).toInt()
}