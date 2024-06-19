package cn_solution

fun countBeautifulPairs(nums: IntArray): Int {
    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    val co = Array(10) { i -> (1..9).filter { j -> gcd(i, j) == 1 } }
    val cnt = IntArray(10)
    return nums.sumOf { num ->
        val result = co[num % 10].sumOf { cnt[it] }
        var head = num
        while (head >= 10)
            head /= 10
        cnt[head]++
        result
    }
}