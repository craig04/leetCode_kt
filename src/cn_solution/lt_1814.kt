package cn_solution

fun countNicePairs(nums: IntArray): Int {
    val map = HashMap<Long, Int>()
    var sum = 0L
    for (n in nums) {
        var rev = 0L
        var temp = n
        while (temp != 0) {
            rev = rev * 10 + temp % 10
            temp /= 10
        }
        val diff = rev - n
        val count = map[diff] ?: 0
        map[diff] = count + 1
        sum += count
    }
    return (sum % 1000000007).toInt()
}