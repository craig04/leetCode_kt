package cn_solution

fun maxSumRangeQuery(nums: IntArray, requests: Array<IntArray>): Int {
    val d = IntArray(nums.size + 1)
    for ((s, e) in requests) {
        d[s]++
        d[e + 1]--
    }
    for (i in nums.indices)
        d[i + 1] += d[i]
    d.sortDescending()
    nums.sortDescending()
    return nums.indices.fold(0) { ans, i ->
        (ans + nums[i] * 1L * d[i]).mod(1000000007)
    }
}