package cn_offer

fun exchange(nums: IntArray): IntArray {
    fun swap(i: Int, j: Int) {
        val tmp = nums[i]
        nums[i] = nums[j]
        nums[j] = tmp
    }

    var i = 0
    var j = nums.lastIndex
    var k = 0
    while (i < j) {
        if (nums[k] and 1 == 1) {
            swap(i++, k++)
        } else {
            swap(j--, k)
        }
    }
    return nums
}