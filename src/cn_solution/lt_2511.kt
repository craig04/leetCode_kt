package cn_solution

fun captureForts(forts: IntArray): Int {
    var pre = 0
    return forts.indices.maxOf {
        var gap = 0
        if (forts[it] != 0) {
            if (forts[it] == -forts[pre])
                gap = it - pre - 1
            pre = it
        }
        gap
    }
}