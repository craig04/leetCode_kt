package cn_solution

fun numOfSubarrays(arr: IntArray): Int {
    val cnt = intArrayOf(1, 0)
    var s = 0
    var ans = 0L
    for (a in arr) {
        s = s xor a and 1
        cnt[s]++
        ans += cnt[s xor 1]
    }
    return ans.mod(1000000007)
}