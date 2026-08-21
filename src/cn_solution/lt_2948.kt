package cn_solution

fun lexicographicallySmallestArray(nums: IntArray, limit: Int): IntArray {
    val n = nums.size
    val a = Array(n) { intArrayOf(it, nums[it]) }
    a.sortBy { it[1] }
    var i = 0
    while (i != n) {
        var j = i + 1
        while (j != n && a[j][1] - a[j - 1][1] <= limit)
            j++
        val pos = IntArray(j - i) { a[i + it][0] }
        pos.sort()
        for (k in pos.indices)
            nums[pos[k]] = a[i + k][1]
        i = j
    }
    return nums
}