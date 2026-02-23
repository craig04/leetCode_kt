package cn_solution

fun sortByBits_method1(arr: IntArray): IntArray {
    return arr.sortedWith(compareBy({ it.countOneBits() }, { it })).toIntArray()
}

fun sortByBits_method2(arr: IntArray): IntArray {
    for (i in arr.indices)
        arr[i] = arr[i].countOneBits().shl(16).or(arr[i])
    arr.sort()
    for (i in arr.indices)
        arr[i] = arr[i].and(0xffff)
    return arr
}