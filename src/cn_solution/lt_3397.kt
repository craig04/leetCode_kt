package cn_solution

fun maxDistinctElements(nums: IntArray, k: Int): Int {
    nums.sort()
    var low = Int.MIN_VALUE
    var ans = 0
    for (num in nums) {
        if (num + k > low) {
            low = maxOf(low + 1, num - k)
            ans++
        }
    }
    return ans
}