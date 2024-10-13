package cn_solution

private fun minOperations(nums: IntArray): Int {
    var ans = 0
    for (num in nums) {
        if (num xor ans and 1 == 0)
            ans++
    }
    return ans
}