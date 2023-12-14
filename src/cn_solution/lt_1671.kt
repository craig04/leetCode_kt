package cn_solution

fun minimumMountainRemovals(nums: IntArray): Int {
    fun lis(indices: IntProgression): IntArray {
        val stack = IntArray(nums.size + 1) { Int.MAX_VALUE }
        var pos = 0
        val result = IntArray(nums.size)
        for (i in indices) {
            var l = 0
            var r = pos
            while (l != r) {
                val m = (l + r) shr 1
                if (nums[i] <= stack[m])
                    r = m
                else
                    l = m + 1
            }
            stack[l] = minOf(stack[l], nums[i])
            pos = maxOf(pos, l + 1)
            result[i] = l + 1
        }
        return result
    }

    val left = lis(nums.indices)
    val right = lis(nums.indices.reversed())
    return nums.size - nums.indices.maxOf {
        if (left[it] == 1 || right[it] == 1)
            0
        else
            left[it] + right[it] - 1
    }
}