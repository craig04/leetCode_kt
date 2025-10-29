package cn_solution

private fun minOperations(nums: IntArray): Int {
    var ans = 0
    var top = -1
    for (num in nums) {
        while (top != -1 && num < nums[top])
            top--
        if (num == 0)
            continue
        if (top == -1 || num > nums[top]) {
            nums[++top] = num
            ans++
        }
    }
    return ans
}