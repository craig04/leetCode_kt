package cn_solution

fun minStartValue(nums: IntArray): Int {
    var sum = 0
    var result = Int.MIN_VALUE
    for (n in nums) {
        sum += n
        result = maxOf(result, 1 - sum)
    }
    return maxOf(1, result)
}