package cn_solution

private fun numberOfPairs(nums1: IntArray, nums2: IntArray, k: Int): Long {
    var max = 0
    val cnt1 = HashMap<Int, Int>()
    for (num in nums1) {
        if (num % k != 0)
            continue
        max = maxOf(max, num / k)
        cnt1.merge(num / k, 1, Int::plus)
    }
    val cnt2 = HashMap<Int, Int>()
    for (num in nums2)
        cnt2.merge(num, 1, Int::plus)
    var ans = 0L
    for ((num, v) in cnt2) {
        for (tmp in num..max step num)
            ans += v.toLong() * (cnt1[tmp] ?: 0)
    }
    return ans
}