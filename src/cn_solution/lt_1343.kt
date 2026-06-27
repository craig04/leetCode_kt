package cn_solution

fun numOfSubarrays(arr: IntArray, k: Int, threshold: Int): Int {
    val sum = k * threshold
    var cur = 0
    return arr.indices.count { i ->
        cur += arr[i]
        if (i >= k)
            cur -= arr[i - k]
        i >= k - 1 && cur >= sum
    }
}