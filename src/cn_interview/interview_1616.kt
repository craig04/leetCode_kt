package cn_interview

fun subSort(array: IntArray): IntArray {
    var left = -1
    var min = Int.MAX_VALUE
    for (i in array.indices.reversed()) {
        if (array[i] > min)
            left = i
        else
            min = array[i]
    }
    var right = -1
    var max = Int.MIN_VALUE
    for (i in array.indices) {
        if (array[i] < max)
            right = i
        else
            max = array[i]
    }
    return intArrayOf(left, right)
}