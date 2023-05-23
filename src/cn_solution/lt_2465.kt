package cn_solution

fun distinctAverages(nums: IntArray): Int {
    nums.sort()
    var i = 0
    var j = nums.lastIndex
    val average = HashSet<Int>()
    while (i < j)
        average.add(nums[i++] + nums[j--])
    return average.size
}