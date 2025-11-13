package cn_solution

fun specialTriplets(nums: IntArray): Int {
    fun plus(a: Int, b: Int): Int = (a + b) % 1000000007
    val one = HashMap<Int, Int>()
    val two = HashMap<Int, Int>()
    var ans = 0
    for (num in nums) {
        if (num % 2 == 0)
            ans = plus(ans, two[num / 2] ?: 0)
        val cnt = one[num * 2] ?: 0
        if (cnt != 0)
            two.merge(num, cnt, ::plus)
        one.merge(num, 1, ::plus)
    }
    return ans
}