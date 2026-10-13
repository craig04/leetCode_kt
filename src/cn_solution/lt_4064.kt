package cn_solution

private fun longestSubarray(nums: IntArray, k: Int): Int {
    val pos = Array(k) { ArrayList<Int>() }
    val l = IntArray(k) { -1 }
    val r = IntArray(k) { -1 }
    l[0] = 0
    r[0] = 0
    var ans = 0
    var sum = 0
    for (i in nums.indices) {
        val x = nums[i] % k + k
        pos[x * 2 % k] += i
        sum = (sum + x) % k
        if (l[sum] == -1)
            l[sum] = i + 1
        else
            ans = maxOf(ans, i - l[sum])
        r[sum] = i + 1
    }
    for (i in 0 until k) {
        if (l[i] == -1)
            continue
        for (j in 0 until k) {
            val len = r[j] - l[i]
            if (r[j] == -1 || len <= ans)
                continue
            val d = (j - i + k) % k
            if (d == 0) {
                ans = len
                continue
            }
            var t = pos[d].binarySearch(l[i])
            if (t < 0)
                t = t.inv()
            if (t != pos[d].size && pos[d][t] < r[j])
                ans = len
        }
    }
    return ans
}