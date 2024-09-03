package cn_solution

fun countGoodIntegers(n: Int, k: Int): Long {
    val p = LongArray(n + 1)
    p[0] = 1
    for (i in 1..n)
        p[i] = p[i - 1] * i
    var s = 1
    repeat(((n + 1) shr 1) - 1) { s *= 10 }
    val vis = HashSet<Long>()
    val cnt = IntArray(10)
    var ans = 0L
    for (i in s until s * 10) {
        var num = i.toLong()
        var j = i
        if (n and 1 == 1)
            j /= 10
        while (j != 0) {
            num = num * 10 + j % 10
            j /= 10
        }
        if (num % k != 0L)
            continue
        cnt.fill(0)
        var tmp = num
        while (tmp != 0L) {
            cnt[(tmp % 10).toInt()]++
            tmp /= 10
        }
        for (t in cnt.indices)
            repeat(cnt[t]) { tmp = tmp * 10 + t }
        if (!vis.add(tmp))
            continue
        ans += cnt.fold((n - cnt[0]) * p[n - 1]) { acc, c -> acc / p[c] }
    }
    return ans
}