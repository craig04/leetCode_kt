package solution_cn

fun runningSum(nums: IntArray): IntArray {
    var sum = 0
    return IntArray(nums.size) {
        sum += nums[it]
        sum
    }
}