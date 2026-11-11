package cn_solution

fun sumSubarrayMins(arr: IntArray): Int {
    val s = arrayListOf(intArrayOf(-1, -1))
    val n = arr.size
    var ans = 0L
    for (r in 0..n) {
        val x = if (r == n) 0 else arr[r]
        while (s.last()[0] >= x) {
            val (y, m) = s.removeLast()
            ans += 1L * (m - s.last()[1]) * (r - m) * y
        }
        s += intArrayOf(x, r)
    }
    return ans.mod(1000000007)
}