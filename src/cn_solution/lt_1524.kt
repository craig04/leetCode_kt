package cn_solution

fun numOfSubarrays(arr: IntArray): Int {
    val cnt = longArrayOf(1, 0)
    var sum = 0
    return arr.sumOf {
        sum = sum xor it and 1
        cnt[sum]++
        cnt[sum xor 1]
    }.mod(1000000007)
}