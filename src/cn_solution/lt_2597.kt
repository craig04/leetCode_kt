package cn_solution

fun beautifulSubsets(nums: IntArray, k: Int): Int {
    val map = HashMap<Int, Int>()
    var ans = -1
    fun dfs(i: Int) {
        if (i == nums.size) {
            ans++
            return
        }
        dfs(i + 1)
        if ((map[nums[i] - k] ?: 0) == 0 && (map[nums[i] + k] ?: 0) == 0) {
            map.merge(nums[i], 1, Int::plus)
            dfs(i + 1)
            map.merge(nums[i], -1, Int::plus)
        }
    }
    dfs(0)
    return ans
}