package cn_solution

fun canTraverseAllPairs(nums: IntArray): Boolean {
    if (nums.size == 1)
        return true
    var max = 1
    for (n in nums) {
        if (n == 1)
            return false
        max = maxOf(max, n)
    }

    val p = IntArray(++max) { it }
    fun find(x: Int): Int {
        if (p[x] == x)
            return x
        p[x] = find(p[x])
        return p[x]
    }

    fun union(x: Int, y: Int) {
        val u = find(x)
        val v = find(y)
        p[v] = u
    }

    val exist = BooleanArray(max)
    for (n in nums) {
        if (n == 1)
            return false
        exist[n] = true
    }
    val prime = BooleanArray(max) { true }
    for (i in 2 until prime.size)
        if (prime[i])
            for (j in i.shl(1) until prime.size step i) {
                prime[j] = false
                if (exist[j])
                    union(i, j)
            }
    val root = find(nums[0])
    return nums.all { find(it) == root }
}