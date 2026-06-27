package cn_solution

private fun countRatioSubarrays(nums: IntArray, a: Int, b: Int): Long {
    val n = nums.size
    val tmp = LongArray(n + 1)
    for (i in nums.indices)
        tmp[i + 1] = tmp[i] + if (nums[i] % 2 == 1) a else -b
    val map = HashMap<Long, Int>()
    tmp.toSortedSet().forEachIndexed { i, s -> map[s] = i + 1 }
    val pre = IntArray(n + 1) { map[tmp[it]]!! }
    val a = IntArray(map.size + 1)
    fun add(x: Int) {
        var y = x
        while (y < a.size) {
            a[y]++
            y += y.takeLowestOneBit()
        }
    }

    fun query(x: Int): Int {
        var ans = 0
        var y = x
        while (y > 0) {
            ans += a[y]
            y = y and (y - 1)
        }
        return ans
    }
    return nums.indices.fold(0L) { acc, i ->
        add(pre[i])
        acc + query(pre[i + 1])
    }
}