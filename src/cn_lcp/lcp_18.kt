package cn_lcp

fun breakfastNumber(staple: IntArray, drinks: IntArray, x: Int): Int {
    staple.sort()
    drinks.sort()
    var j = drinks.lastIndex
    return staple.indices.fold(0) { ans, i ->
        while (j >= 0 && staple[i] + drinks[j] > x)
            j--
        (ans + j + 1) % 1000000007
    }
}