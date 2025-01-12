package cn_solution

fun subsetsWithDup(nums: IntArray): List<List<Int>> {
    val ans = ArrayList<List<Int>>()
    val cur = ArrayList<Int>()
    fun dfs(i: Int) {
        ans.add(ArrayList(cur))
        for (j in i until nums.size)
            if (j == i || nums[j] != nums[j - 1]) {
                cur.add(nums[j])
                dfs(j + 1)
                cur.removeLast()
            }
    }
    nums.sort()
    dfs(0)
    return ans
}