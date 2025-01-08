package cn_solution

fun maximumWeight(intervals: List<List<Int>>): IntArray {

    class Info(var sum: Long, var idx: ArrayList<Int>) {
        fun set(other: Info) {
            sum = other.sum
            idx.addAll(other.idx)
        }
    }

    val itv = Array(intervals.size) { i ->
        val t = intervals[i]
        intArrayOf(t[0], t[1], t[2], i)
    }
    itv.sortBy { it[1] }
    val dp = Array(intervals.size + 1) { Array(5) { Info(0, arrayListOf()) } }
    for (i in itv.indices) {
        val (l, _, w, t) = itv[i]
        var a = -1
        var b = i - 1
        while (a != b) {
            val m = (a + b + 1) / 2
            if (itv[m][1] < l)
                a = m
            else
                b = m - 1
        }
        for (j in 1..4) {
            val s1 = dp[i][j].sum
            val s2 = dp[a + 1][j - 1].sum + w
            if (s1 > s2) {
                dp[i + 1][j].set(dp[i][j])
                continue
            }
            dp[i + 1][j].sum = s2
            var new = ArrayList(dp[a + 1][j - 1].idx)
            new.add(t)
            new.sort()
            if (s1 == s2) {
                for (k in 0 until minOf(dp[i][j].idx.size, new.size))
                    if (dp[i][j].idx[k] < new[k]) {
                        new = dp[i][j].idx
                        break
                    }
            }
            dp[i + 1][j].idx = new
        }
    }
    return dp.last()[4].idx.toIntArray()
}