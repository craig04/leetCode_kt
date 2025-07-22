package cn_solution

fun maximumUniqueSubarray(nums: IntArray): Int {
    var ans = 0
    var sum = 0
    var i = 0
    val set = HashSet<Int>()
    for (j in nums.indices) {
        while (nums[j] in set) {
            set.remove(nums[i])
            sum -= nums[i++]
        }
        set.add(nums[j])
        sum += nums[j]
        ans = maxOf(ans, sum)
    }
    return ans
}