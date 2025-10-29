package cn_solution

fun subarraysDivByK(nums: IntArray, k: Int): Int {
    val cnt = IntArray(k)
    cnt[0] = 1
    var sum = 0
    return nums.sumOf { num ->
        sum += num
        cnt[(sum % k + k) % k]++
    }
}