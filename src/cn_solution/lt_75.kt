package cn_solution

fun sortColors(nums: IntArray): Unit {
    fun swap(i: Int, j: Int) {
        val tmp = nums[i]
        nums[i] = nums[j]
        nums[j] = tmp
    }

    var a = 0
    var b = nums.lastIndex
    var i = 0
    while (i <= b) {
        while (i <= b && nums[i] == 2) {
            swap(i, b--)
        }
        if (nums[i] == 0) {
            swap(i, a++)
        }
        i++
    }
}
