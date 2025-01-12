package cn_solution

fun maxFrequency(nums: IntArray, k: Int): Int {
    val n = nums.size
    val pre = IntArray(n + 1)
    val map = Array(51) { ArrayList<Int>() }
    nums.forEachIndexed { i, num ->
        pre[i + 1] = pre[i]
        if (num == k)
            pre[i + 1]++
        map[num].add(i)
    }
    var ans = 0
    for (pos in map) {
        var max = Int.MIN_VALUE
        for (i in pos.indices) {
            val p = pos[i]
            max = maxOf(max, pre[p] - i)
            ans = maxOf(ans, pre[n] + max + i - pre[p + 1] + 1)
        }
    }
    return ans
}