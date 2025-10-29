package cn_solution

fun numGoodSubarrays(nums: IntArray, k: Int): Long {
    val cnt = hashMapOf(0 to 1)
    var sum = 0L
    var ans = nums.sumOf { num ->
        sum += num
        cnt.merge(sum.mod(k), 1, Int::plus)!! - 1L
    }
    var i = 0
    val n = nums.size
    while (i != n) {
        var j = i + 1
        while (j != n && nums[j] == nums[i])
            j++
        for (len in 1 until j - i)
            if (nums[i] * 1L * len % k == 0L)
                ans -= j - i - len
        i = j
    }
    return ans
}