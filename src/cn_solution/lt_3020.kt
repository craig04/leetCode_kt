package cn_solution

private fun maximumLength(nums: IntArray): Int {
    val map = nums.asSequence().groupingBy { it }.eachCountTo(HashMap())
    val tmp = map.remove(1)
    var ans = if (tmp == null) 0 else (tmp - 1) or 1
    for ((k, v) in map) {
        var pow = k
        var cnt = v
        var len = 1
        while (cnt >= 2) {
            pow *= pow
            cnt = map[pow] ?: break
            len += 2
        }
        ans = maxOf(ans, len)
    }
    return ans
}