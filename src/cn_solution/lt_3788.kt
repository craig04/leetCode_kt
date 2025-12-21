package cn_solution

fun maximumScore(nums: IntArray): Long {
    var pre = nums.fold(0L, Long::plus)
    var suf = Int.MAX_VALUE
    return (nums.lastIndex downTo 1).maxOf {
        pre -= nums[it]
        suf = minOf(suf, nums[it])
        pre - suf
    }
}