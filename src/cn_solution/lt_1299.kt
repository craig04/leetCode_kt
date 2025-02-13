package cn_solution

fun replaceElements(arr: IntArray): IntArray {
    var max = -1
    val ans = IntArray(arr.size)
    for (i in arr.indices.reversed()) {
        ans[i] = max
        max = maxOf(max, arr[i])
    }
    return ans
}