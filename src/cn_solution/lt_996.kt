package cn_solution

fun numSquarefulPerms(nums: IntArray): Int {
    val square = HashSet<Int>()
    var t = 0
    do {
        square.add(t * t)
        t++
    } while (Int.MAX_VALUE / t >= t)
    val n = nums.size
    val used = BooleanArray(n)
    var result = 0
    nums.sort()
    fun dfs(pos: Int, prev: Int) {
        if (pos == n) {
            result++
            return
        }
        nums.indices.asSequence()
            .filter { !used[it] }
            .filter { it == 0 || nums[it] != nums[it - 1] || used[it - 1] }
            .filter { pos == 0 || nums[it] + prev in square }
            .forEach {
                used[it] = true
                dfs(pos + 1, nums[it])
                used[it] = false
            }
    }
    dfs(0, 0)
    return result
}