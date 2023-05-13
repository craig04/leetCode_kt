package cn_solution

fun addNegabinary(arr1: IntArray, arr2: IntArray): IntArray {
    val list = ArrayList<Int>()
    var carry = 0
    var i1 = arr1.lastIndex
    var i2 = arr2.lastIndex
    while (i1 >= 0 || i2 >= 0 || carry != 0) {
        var bit = 0
        if (i1 >= 0) bit += arr1[i1--]
        if (i2 >= 0) bit += arr2[i2--]
        bit += carry
        carry = when {
            bit <= -1 -> 1
            bit >= 2 -> -1
            else -> 0
        }
        bit = bit and 1
        list.add(bit)
    }
    while (list.size > 1 && list.last() == 0) {
        list.removeAt(list.lastIndex)
    }
    return list.asReversed().toIntArray()
}