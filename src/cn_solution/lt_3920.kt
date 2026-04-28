package cn_solution

fun maxFixedPoints(nums: IntArray): Int {
    val a = ArrayList<IntArray>()
    for (i in nums.indices)
        if (i >= nums[i])
            a.add(intArrayOf(nums[i], i - nums[i]))
    a.sortWith(compareBy({ it[1] }, { it[0] }))
    val s = arrayListOf(-1)
    for ((x) in a) {
        var t = s.binarySearch(x)
        if (t < 0)
            t = -t - 1
        if (t == s.size)
            s.add(x)
        else
            s[t] = minOf(s[t], x)
    }
    return s.lastIndex
}