package cn_solution

fun countMatchingSubarrays(nums: IntArray, pattern: IntArray): Int {
    val a = IntArray(nums.size - 1)
    for (i in 0 until nums.lastIndex)
        a[i] = nums[i + 1].compareTo(nums[i])
    val m = pattern.size
    return (0..(a.size - m)).count {
        java.util.Arrays.compare(a, it, it + m, pattern, 0, m) == 0
    }
}