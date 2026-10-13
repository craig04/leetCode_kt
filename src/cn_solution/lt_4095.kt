package cn_solution

private fun countStaircase(nums: IntArray): Int {
    val n = nums.size
    val pos = HashMap<Int, ArrayDeque<Int>>()
    val first = ArrayDeque<Int>()
    var ans = 0
    for (i in nums.indices.reversed()) {
        var x = nums[i]
        pos.getOrPut(x) { ArrayDeque() }.addFirst(i)
        first.remove(x)
        first.addFirst(x)
        val m = first.size
        if (m * (m + 1) / 2 > n)
            first.removeLast()
        var j = i
        var min = n
        var max = 0
        for (k in 1..first.size) {
            j += k
            if (j > n)
                break
            x = first[k - 1]
            val p = pos[x] ?: emptyList()
            if (p.size < k)
                break
            max = maxOf(max, p[k - 1])
            min = minOf(min, p.getOrNull(k) ?: n)
            if (max >= min || min < j)
                break
            if (j > max)
                ans++
        }
    }
    return ans
}