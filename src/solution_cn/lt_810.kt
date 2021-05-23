package solution_cn

fun xorGame(nums: IntArray): Boolean {
    return nums.size % 2 == 0 || nums.reduce { acc, i -> acc xor i } == 0
}