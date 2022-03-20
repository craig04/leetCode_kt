package cn_solution

fun countMaxOrSubsets(nums: IntArray): Int {
    val n = nums.size
    val target = nums.reduce { a, b -> a or b }
    fun search(t: Int, i: Int): Int = when {
        t == target -> 1.shl(n - i)
        i == n -> 0
        else -> search(t or nums[i], i + 1) + search(t, i + 1)
    }
    return search(0, 0)
}