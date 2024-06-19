package cn_solution

fun countDifferentSubsequenceGCDs(nums: IntArray): Int {
    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    val max = nums.max()
    val occur = BooleanArray(max + 1)
    for (num in nums)
        occur[num] = true
    return (1..max).count { i ->
        var sub = 0
        for (j in i..max step i) {
            if (occur[j]) {
                sub = if (sub == 0) j else gcd(sub, j)
                if (sub == i)
                    break
            }
        }
        sub == i
    }
}