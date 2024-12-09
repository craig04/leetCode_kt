package cn_solution

fun wiggleSort(nums: IntArray): Unit {
    val sort = nums.sortedArray()
    val n = nums.size
    var i = 0
    var j = (n - 1) / 2
    var k = n - 1
    while (i < n - 1) {
        nums[i++] = sort[j--]
        nums[i++] = sort[k--]
    }
    if (j == 0)
        nums[i] = sort[j]
}