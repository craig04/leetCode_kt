package cn_solution

fun sumOfUnique(nums: IntArray): Int {
    val state = IntArray(101)
    return nums.sumBy {
        when (++state[it]) {
            1 -> it
            2 -> -it
            else -> 0
        }
    }
}