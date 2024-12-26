package cn_solution

fun maxConsecutive(bottom: Int, top: Int, special: IntArray): Int {
    special.sort()
    var pre = bottom
    return special.maxOf {
        val old = pre
        pre = it + 1
        it - old
    }.coerceAtLeast(top - pre + 1)
}