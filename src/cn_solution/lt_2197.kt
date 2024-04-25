package cn_solution

fun replaceNonCoprimes(nums: IntArray): List<Int> {
    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    val result = ArrayList<Int>()
    for (i in nums.indices) {
        var num = nums[i]
        while (result.isNotEmpty()) {
            val gcd = gcd(result.last(), num)
            if (gcd == 1)
                break
            num *= result.removeLast() / gcd
        }
        result.add(num)
    }
    return result
}