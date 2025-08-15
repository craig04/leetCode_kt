package cn_solution

fun componentValue(nums: IntArray, edges: Array<IntArray>): Int {
    var max = 0
    var sum = 0
    for (num in nums) {
        max = maxOf(max, num)
        sum += num
    }
    val g = Array(nums.size) { ArrayList<Int>() }
    for ((u, v) in edges) {
        g[u].add(v)
        g[v].add(u)
    }
    return sum / (max..sum).first { i ->
        fun dfs(u: Int, p: Int): Int {
            var res = nums[u]
            for (v in g[u])
                if (v != p) {
                    val s = dfs(v, u)
                    if (s == -1)
                        return -1
                    res += s
                    if (res > i)
                        return -1
                }
            return res % i
        }
        sum % i == 0 && dfs(0, -1) == 0
    } - 1
}