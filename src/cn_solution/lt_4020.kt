package cn_solution

import kotlin.math.abs

fun elevatorRequests(n: Int, requests: IntArray): Int {
    var cur = 0
    var ans = 0
    for (request in requests) {
        ans += abs(request - cur)
        cur = request
    }
    return ans
}