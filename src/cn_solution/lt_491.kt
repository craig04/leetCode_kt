package cn_solution

fun findSubsequences(nums: IntArray): List<List<Int>> {
    val result = ArrayList<List<Int>>()
    val list = ArrayList<Int>()
    fun dfs(i: Int, prev: Int) {
        if (i == nums.size) {
            if (list.size >= 2)
                result.add(ArrayList(list))
            return
        }
        if (nums[i] >= prev) {
            list.add(nums[i])
            dfs(i + 1, nums[i])
            list.removeLast()
        }
        if (nums[i] != prev)
            dfs(i + 1, nums[i])
    }
    dfs(0, Int.MIN_VALUE)
    return result
}