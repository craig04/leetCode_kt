package cn_solution

fun countFairPairs(nums: IntArray, lower: Int, upper: Int): Long {
    nums.sort()
    val n = nums.size
    fun count(sum: Int): Long {
        var ans = 0L
        var i = 0
        var j = nums.lastIndex
        while (i < j) {
            while (i < j && nums[i] + nums[j] > sum)
                j--
            ans += j - i++
        }
        return ans
    }
    return count(upper) - count(lower - 1)
}