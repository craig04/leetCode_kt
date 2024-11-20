package cn_solution

fun sortByBits(arr: IntArray): IntArray {
    return arr.sortedWith(compareBy({ it.countOneBits() }, { it })).toIntArray()
}