package cn_solution

fun maxProductPair(nums: IntArray, target: Int): IntArray {
    val ans = intArrayOf(-1, -1)
    var max = Int.MIN_VALUE
    val map = HashMap<Int, Int>()
    for (i in nums.indices) {
        val x = nums[i]
        if (x * 2 == target)
            continue
        val y = target - x
        val j = map[y]
        if (j != null && x * y > max) {
            val pos = if (x > y) 0 else 1
            ans[pos] = i
            ans[pos xor 1] = j
            max = x * y
        }
        map[x] = i
    }
    return ans
}