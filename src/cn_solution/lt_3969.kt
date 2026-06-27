package cn_solution

fun countValidSubarrays(nums: IntArray, x: Int): Int {
    val y = x + 0L
    return nums.indices.sumOf { i ->
        var sum = 0L
        (i until nums.size).count { j ->
            sum += nums[j]
            if (sum % 10 != y)
                return@count false
            var tmp = sum
            while (tmp >= 10)
                tmp /= 10
            tmp == y
        }
    }
}