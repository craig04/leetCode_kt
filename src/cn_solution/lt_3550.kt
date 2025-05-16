package cn_solution

fun smallestIndex(nums: IntArray): Int {
    return nums.indices.indexOfFirst {
        var sum = 0
        var num = nums[it]
        while (num != 0) {
            sum += num % 10
            num /= 10
        }
        sum == it
    }
}