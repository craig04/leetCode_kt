package cn_lcp

fun beautifulBouquet(flowers: IntArray, cnt: Int): Int {
    val f = IntArray(100001)
    var i = 0
    return flowers.indices.fold(0) { ans, j ->
        f[flowers[j]]++
        while (f[flowers[j]] > cnt)
            f[flowers[i++]]--
        (ans + j - i + 1) % 1000000007
    }
}