package cn_solution

import kotlin.math.abs

fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
    val n = arr.size
    var ans = 0
    for (i in 0 until n - 2)
        for (j in i + 1 until n - 1)
            if (abs(arr[i] - arr[j]) <= a)
                for (k in j + 1 until n)
                    if (abs(arr[j] - arr[k]) <= b && abs(arr[i] - arr[k]) <= c)
                        ans++
    return ans
}