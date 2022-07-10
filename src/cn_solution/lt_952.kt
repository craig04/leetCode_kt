package cn_solution

import base.UnionFind

fun largestComponentSize(nums: IntArray): Int {
    val max = nums.reduce { a, b -> maxOf(a, b) }
    val uf = UnionFind(max + 1)
    for (n in nums) {
        var temp = 2
        while (temp * temp <= n) {
            if (n % temp == 0) {
                uf.union(n, temp)
                uf.union(n, n / temp)
            }
            temp++
        }
    }
    val map = HashMap<Int, Int>()
    var result = 0
    for (n in nums) {
        val root = uf.find(n)
        var count = map[root] ?: 0
        map[root] = ++count
        result = maxOf(result, count)
    }
    return result
}