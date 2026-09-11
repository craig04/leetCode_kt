package cn_solution

fun minSumOfLengths(arr: IntArray, target: Int): Int {
    val n = arr.size
    val min = IntArray(n + 1)
    min[0] = n + 1
    var i = 0
    var sum = 0
    var ans = Int.MAX_VALUE
    for (j in arr.indices) {
        sum += arr[j]
        while (sum > target)
            sum -= arr[i++]
        min[j + 1] = min[j]
        if (sum == target) {
            val len = j - i + 1
            ans = minOf(ans, len + min[i])
            min[j + 1] = minOf(min[j + 1], len)
        }
    }
    return if (ans > n) -1 else ans
}