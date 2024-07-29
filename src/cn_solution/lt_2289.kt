package cn_solution

fun totalSteps(nums: IntArray): Int {
    val idx = IntArray(nums.size)
    val cnt = IntArray(nums.size)
    var top = -1
    return nums.indices.maxOf {
        val num = nums[it]
        var cur = 0
        while (top != -1 && num >= nums[idx[top]])
            cur = maxOf(cur, cnt[top--])
        if (++top == 0)
            cnt[top] = 0
        else
            cnt[top] = cur + 1
        idx[top] = it
        cnt[top]
    }
}