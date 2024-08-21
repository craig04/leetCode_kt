package cn_solution

fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
    val sum = nums.sum()
    if (sum % k != 0)
        return false
    val sub = sum / k
    val n = nums.size
    val dp = HashMap<Int, Boolean>()
    fun dfs(bits: Int, acc: Int): Boolean {
        if (bits == 0)
            return acc == 0
        return dp.getOrPut(bits) {
            nums.indices.any { i ->
                1.shl(i).and(bits) != 0
                        && acc + nums[i] <= sub
                        && dfs(1.shl(i).xor(bits), (acc + nums[i]) % sub)
            }
        }
    }
    return dfs(1.shl(n) - 1, 0)
}