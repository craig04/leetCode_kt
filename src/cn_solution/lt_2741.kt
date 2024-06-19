package cn_solution

fun specialPerm(nums: IntArray): Int {
    val modulo = 1000000007
    val n = nums.size
    val g = Array(n) { i -> BooleanArray(n) { j -> nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0 } }
    val dp = HashMap<Int, Long>()
    fun dfs(all: Int, last: Int): Long {
        return dp.getOrPut(all * n + last) {
            val other = 1 shl last xor all
            if (other == 0) {
                return@getOrPut 1
            }
            var result = 0L
            for (i in 0 until n)
                if (1 shl i and other != 0 && g[i][last])
                    result += dfs(other, i)
            result % modulo
        }
    }

    val mask = 1.shl(n) - 1
    return (0 until n).sumOf { dfs(mask, it) }.rem(modulo).toInt()
}