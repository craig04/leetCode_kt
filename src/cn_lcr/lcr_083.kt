package cn_lcr

fun permute(nums: IntArray): List<List<Int>> {
    val visit = BooleanArray(nums.size)
    val list = ArrayList<Int>()
    val result = ArrayList<List<Int>>()
    fun dfs() {
        if (list.size == nums.size) {
            result.add(ArrayList(list))
            return
        }
        for (i in nums.indices) {
            if (!visit[i]) {
                visit[i] = true
                list.add(nums[i])
                dfs()
                list.removeLast()
                visit[i] = false
            }
        }
    }
    dfs()
    return result
}