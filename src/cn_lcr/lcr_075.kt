package cn_lcr

fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
    val map = arr2.associateWithTo(HashMap()) { 0 }
    var l = 0
    for (i in arr1.indices) {
        val cnt = map[arr1[i]] ?: continue
        map[arr1[i]] = cnt + 1
        val tmp = arr1[i]
        arr1[i] = arr1[l]
        arr1[l++] = tmp
    }
    l = 0
    for (a in arr2)
        for (i in 0 until (map[a] ?: 0))
            arr1[l++] = a
    arr1.sort(l)
    return arr1
}