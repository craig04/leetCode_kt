package cn_solution

fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    val set = HashSet<Int>()
    return nums.indices.any {
        if (it > k) set.remove(nums[it - k - 1])
        !set.add(nums[it])
    }
}