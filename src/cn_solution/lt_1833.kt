package cn_solution

fun maxIceCream(costs: IntArray, coins: Int): Int {
    val cnt = IntArray(100001)
    for (cost in costs)
        cnt[cost]++
    var ans = 0
    var left = coins
    for (i in 1 until cnt.size) {
        val x = minOf(cnt[i], left / i)
        ans += x
        left -= x * i
        if (left < i)
            break
    }
    return ans
}