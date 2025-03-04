package cn_solution

fun countOfPeaks(nums: IntArray, queries: Array<IntArray>): List<Int> {
    val n = nums.size
    val a = IntArray(n + 1)
    fun modify(x: Int, t: Int) {
        var y = x
        while (y <= n) {
            a[y] += t
            y += y and -y
        }
    }

    fun query(x: Int): Int {
        var ans = 0
        var y = x
        while (y > 0) {
            ans += a[y]
            y = y and y - 1
        }
        return ans
    }

    fun peak(i: Int) = nums[i] > maxOf(nums[i - 1], nums[i + 1])
    for (i in 1 until n - 1)
        if (nums[i] > maxOf(nums[i - 1], nums[i + 1]))
            modify(i + 1, 1)
    val ans = ArrayList<Int>()
    val t = intArrayOf(-1, 0, 1)
    for ((type, x, y) in queries) {
        if (type == 1) {
            ans.add(if (y > x + 1) query(y) - query(x + 1) else 0)
            continue
        }
        val d = IntArray(3)
        for (i in 0..2) {
            val p = x + t[i]
            if (p > 0 && p < n - 1 && peak(p))
                d[i]--
        }
        nums[x] = y
        for (i in 0..2) {
            val p = x + t[i]
            if (p > 0 && p < n - 1 && peak(p))
                d[i]++
            if (d[i] != 0)
                modify(p + 1, d[i])
        }
    }
    return ans
}