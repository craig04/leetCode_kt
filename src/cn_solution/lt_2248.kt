package cn_solution

fun intersection(nums: Array<IntArray>): List<Int> {
    val cnt = IntArray(1001)
    for (num in nums)
        for (x in num)
            cnt[x]++
    return cnt.indices.filter { cnt[it] == nums.size }
}