package cn_solution

fun distantSubarrays(nums: IntArray, goal: Int, k: Int): Long {
    val n = nums.size
    val a = IntArray(n + 2)
    fun add(x: Int) {
        var t = x
        while (t < a.size) {
            a[t]++
            t += t and -t
        }
    }

    fun query(x: Int): Int {
        var res = 0
        var t = x
        while (t > 0) {
            res += a[t]
            t = t and (t - 1)
        }
        return res
    }

    val pre = LongArray(n + 1)
    for (i in 0 until n)
        pre[i + 1] = pre[i] + nums[i]
    pre.sort()
    fun lower(x: Long): Int {
        var l = 0
        var r = pre.size
        while (l < r) {
            val mid = (l + r) / 2
            if (pre[mid] < x)
                l = mid + 1
            else
                r = mid
        }
        return l
    }

    var ans = n * (n + 1L) / 2
    add(lower(0) + 1)
    var sum = 0L
    for (i in 0 until n) {
        sum += nums[i]
        val r = lower(sum - goal + k)
        val l = lower(sum - goal - k + 1)
        if (l <= r)
            ans -= query(r) - query(l)
        add(lower(sum) + 1)
    }
    return ans
}