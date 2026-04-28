package cn_solution

fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
    val set = HashSet<Int>()
    for (a in arr1) {
        var x = a
        while (x != 0 && set.add(x))
            x /= 10
    }
    var max = 0
    for (a in arr2) {
        var x = a
        while (x != 0 && x !in set)
            x /= 10
        max = maxOf(max, x)
    }
    return if (max == 0) 0 else max.toString().length
}