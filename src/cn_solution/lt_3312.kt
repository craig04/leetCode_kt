package cn_solution

fun gcdValues(nums: IntArray, queries: LongArray): IntArray {
    val max = nums.max()
    val cnt = IntArray(max + 1)
    for (num in nums)
        cnt[num]++
    val gcd = LongArray(max + 1)
    for (i in max downTo 1) {
        var acc = cnt[i]
        for (j in 2 * i..max step i) {
            acc += cnt[j]
            gcd[i] -= gcd[j]
        }
        gcd[i] += (acc - 1L) * acc / 2
    }
    for (i in 2..max)
        gcd[i] += gcd[i - 1]
    return IntArray(queries.size) {
        var l = 1
        var r = max
        while (l != r) {
            val m = (l + r) / 2
            if (gcd[m] < queries[it] + 1)
                l = m + 1
            else
                r = m
        }
        l
    }
}