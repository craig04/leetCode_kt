package cn_solution

fun maximumPrimeDifference(nums: IntArray): Int {
    val p = BooleanArray(101) { true }
    p[1] = false
    for (i in 2..100) {
        if (p[i])
            for (j in i + i..100 step i)
                p[j] = false
    }
    val first = nums.indexOfFirst { p[it] }
    val last = (nums.lastIndex downTo first).first { p[nums[it]] }
    return last - first
}