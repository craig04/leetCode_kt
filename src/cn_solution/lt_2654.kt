package cn_solution

fun minOperations(nums: IntArray): Int {
    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    val cnt = nums.count { it == 1 }
    if (cnt != 0)
        return nums.size - cnt
    for (len in 1..nums.size)
        for (i in 0..nums.size - len)
            if (nums.asList().subList(i, i + len).reduce(::gcd) == 1)
                return nums.size + len - 2
    return -1
}