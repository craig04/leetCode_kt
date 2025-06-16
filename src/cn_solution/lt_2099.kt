package cn_solution

fun maxSubsequence(nums: IntArray, k: Int): IntArray {
    val idx = Array(nums.size) { it }
    idx.sortByDescending { nums[it] }
    idx.sort(0, k)
    return IntArray(k) { nums[idx[it]] }
}