package cn_solution

fun separateDigits(nums: IntArray): IntArray {
    val ans = ArrayDeque<Int>()
    for (i in nums.indices.reversed()) {
        var num = nums[i]
        do {
            ans.addFirst(num % 10)
            num /= 10
        } while (num != 0)
    }
    return ans.toIntArray()
}