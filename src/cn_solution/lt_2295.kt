package cn_solution

fun arrayChange(nums: IntArray, operations: Array<IntArray>): IntArray {
    val maps = HashMap<Int, Int>()
    for (i in nums.indices)
        maps[nums[i]] = i
    for ((old, new) in operations) {
        val pos = maps.remove(old) ?: 0
        nums[pos] = new
        maps[new] = pos
    }
    return nums
}