package cn_solution

fun sortArrayByParityII(nums: IntArray): IntArray {
    var i = 0
    var j = 1
    while (i < nums.size) {
        when {
            nums[i] % 2 == 0 -> i += 2
            nums[j] % 2 == 1 -> j += 2
            else -> {
                val tmp = nums[i]
                nums[i] = nums[j]
                nums[j] = tmp
                i += 2
                j += 2
            }
        }
    }
    return nums
}