package cn_solution

fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
    val map = hashMapOf(0 to -1)
    var sum = 0
    return nums.indices.any {
        sum = (sum + nums[it]) % k
        it - map.getOrPut(sum) { it } >= 2
    }
}