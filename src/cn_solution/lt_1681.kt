package cn_solution

fun minimumIncompatibility(nums: IntArray, k: Int): Int {
    val n = nums.size
    val group = n / k
    val status = 1.shl(n)
    val compability = HashMap<Int, Int>()
    outer@ for (i in 1 until status) {
        if (Integer.bitCount(i) != group)
            continue
        val s = HashSet<Int>()
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        for (j in 0 until n) {
            if (1.shl(j).and(i) == 0)
                continue
            val num = nums[j]
            if (!s.add(num))
                continue@outer
            min = minOf(min, num)
            max = maxOf(max, num)
        }
        compability[i] = max - min
    }
    val dp = IntArray(status) { Int.MAX_VALUE }
    dp[0] = 0
    for (i in 0 until status) {
        if (dp[i] == Int.MAX_VALUE)
            continue
        val pick = HashMap<Int, Int>()
        for (j in 0 until n)
            if (1.shl(j).and(i) == 0)
                pick[nums[j]] = j
        if (pick.size < group)
            continue
        val mask = pick.entries.fold(0) { acc, (_, v) -> 1.shl(v).or(acc) }
        var temp = mask
        while (temp != 0) {
            compability[temp]?.let {
                val t = i or temp
                dp[t] = minOf(dp[t], dp[i] + it)
            }
            temp = (temp - 1) and mask
        }
    }
    return dp[status - 1].let { if (it == Int.MAX_VALUE) -1 else it }
}