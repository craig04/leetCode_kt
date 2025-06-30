package cn_solution

fun minOperations(target: IntArray, arr: IntArray): Int {
    val map = HashMap<Int, Int>()
    for (i in target.indices) {
        map[target[i]] = i
        target[i] = i
    }
    val x = arrayListOf(Int.MIN_VALUE)
    for (a in arr) {
        val b = map[a] ?: continue
        var i = x.binarySearch(b)
        if (i >= 0)
            continue
        i = -i - 1
        if (i == x.size)
            x.add(b)
        else
            x[i] = b
    }
    return target.size - x.lastIndex
}