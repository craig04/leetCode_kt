package cn_solution

fun nextBeautifulNumber(n: Int): Int {
    var res = n + 1
    val cnt = IntArray(10)
    do {
        cnt.fill(0)
        var t = res
        while (t > 0) {
            cnt[t % 10]++
            t /= 10
        }
        if (cnt.indices.all { cnt[it] == 0 || cnt[it] == it })
            return res
        res++
    } while (true)
}