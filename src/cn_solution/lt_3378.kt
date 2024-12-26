package cn_solution

fun countComponents(nums: IntArray, threshold: Int): Int {
    val n = nums.size
    val p = IntArray(n) { it }
    fun find(x: Int): Int {
        if (p[x] != x)
            p[x] = find(p[x])
        return p[x]
    }

    fun union(x: Int, y: Int) {
        p[find(x)] = find(y)
    }

    val pos = IntArray(threshold + 1) { -1 }
    for (i in nums.indices)
        if (nums[i] <= threshold)
            pos[nums[i]] = i
    for (t in 1..threshold) {
        val x = (t..threshold step t).firstOrNull { pos[it] != -1 } ?: continue
        for (y in t * 2..threshold step t) {
            if (1L * x * y / t > threshold)
                break
            if (pos[y] != -1)
                union(pos[x], pos[y])
        }
    }
    return (0 until n).count { p[it] == it }
}