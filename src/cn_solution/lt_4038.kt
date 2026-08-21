package cn_solution

fun countSpecialIntegers(nums: IntArray): Int {
    val map = HashMap<Int, Int>()
    var ans = 0
    for (i in nums.indices) {
        if (i != 0 && nums[i - 1] == nums[i])
            continue
        when (map.merge(nums[i], 1, Int::plus)) {
            1 -> ans++
            2 -> ans--
        }
    }
    return ans
}