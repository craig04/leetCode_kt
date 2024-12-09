package cn_solution

fun minMoves(nums: IntArray): Int {
    var min = Int.MAX_VALUE
    var sum = 0L
    for (num in nums) {
        min = minOf(min, num)
        sum += num
    }
    return (sum - min * nums.size).toInt()
}