package cn_solution

private fun countMajoritySubarrays(nums: IntArray, target: Int): Long {
    val n = nums.size
    val cnt = IntArray(n * 2 + 1)
    cnt[n] = 1
    var sum = n
    var cur = 0L
    return nums.sumOf {
        if (it == target)
            cur += cnt[sum++]
        else
            cur -= cnt[--sum]
        cnt[sum]++
        cur
    }
}