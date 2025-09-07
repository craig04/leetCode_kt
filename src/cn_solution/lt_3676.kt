package cn_solution

fun bowlSubarrays(nums: IntArray): Long {
    val s = IntArray(nums.size)
    var top = -1
    var ans = 0L
    nums.forEachIndexed { i, num ->
        while (top != -1 && num >= nums[s[top]])
            if (--top != -1)
                ans++
        s[++top] = i
    }
    return ans
}