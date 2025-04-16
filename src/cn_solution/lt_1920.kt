package cn_solution

fun buildArray(nums: IntArray): IntArray {
    for (i in nums.indices) {
        if (nums[i] < 0)
            continue
        val tmp = nums[i]
        var j = i
        while (nums[j] != i) {
            val k = nums[j]
            nums[j] = nums[k].inv()
            j = k
        }
        nums[j] = tmp.inv()
    }
    for (i in nums.indices)
        nums[i] = nums[i].inv()
    return nums
}