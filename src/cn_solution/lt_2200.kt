package cn_solution

fun findKDistantIndices(nums: IntArray, key: Int, k: Int): List<Int> {
    val ans = ArrayList<Int>()
    var t = 0
    for (i in nums.indices)
        if (nums[i] == key) {
            val b = maxOf(t, i - k)
            val e = minOf(i + k + 1, nums.size)
            ans.addAll(b until e)
            t = e
        }
    return ans
}