package cn_solution

fun plusOne(digits: IntArray): IntArray {
    val result = ArrayList<Int>()
    var c = 1
    for (i in digits.indices.reversed()) {
        val sum = digits[i] + c
        result.add(sum % 10)
        c = sum / 10
    }
    if (c != 0)
        result.add(1)
    return result.asReversed().toIntArray()
}