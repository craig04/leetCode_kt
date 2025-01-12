package cn_solution

fun permuteUnique(nums: IntArray): List<List<Int>> {
    fun swap(i: Int, j: Int) {
        val tmp = nums[i]
        nums[i] = nums[j]
        nums[j] = tmp
    }
    nums.sort()
    val ans = ArrayList<List<Int>>()
    while (true) {
        ans.add(nums.toList())
        var i = nums.lastIndex - 1
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--
        if (i < 0)
            break
        var j = nums.lastIndex
        while (nums[i] >= nums[j])
            j--
        swap(i++, j)
        j = nums.lastIndex
        while (i < j)
            swap(i++, j--)
    }
    return ans
}
