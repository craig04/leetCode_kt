package cn_solution

fun arrayNesting(nums: IntArray): Int {
    return nums.indices.fold(0) { result, i ->
        var count = 0
        var j = i
        while (nums[j] != nums.size) {
            count++
            val temp = nums[j]
            nums[j] = nums.size
            j = temp
        }
        maxOf(result, count)
    }
}