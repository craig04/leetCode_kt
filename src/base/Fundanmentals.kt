package base

import java.util.*

val random = Random()

fun IntArray.swap(i: Int, j: Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}

fun IntArray.nthElement(left: Int, right: Int, n: Int): Int {
    val index = random.nextInt(right - left) + left
    val pivot = this[index]
    var i = left - 1
    swap(index, right - 1)
    for (j in left until right) {
        if (this[j] <= pivot) {
            swap(++i, j)
        }
    }
    return when {
        i < n -> nthElement(i + 1, right, n)
        i > n -> nthElement(left, i, n)
        else -> this[i]
    }
}