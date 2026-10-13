package cn_solution

fun countOppositeParity(nums: IntArray): IntArray {
    val ans = IntArray(nums.size)
    val cnt = IntArray(2)
    for (i in nums.indices.reversed()) {
        val x = nums[i] % 2
        ans[i] = cnt[x xor 1]
        cnt[x]++
    }
    return ans
}