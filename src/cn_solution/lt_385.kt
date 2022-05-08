package cn_solution

import base.NestedInteger

fun deserialize(s: String): NestedInteger {
    val ca = s.toCharArray()
    var pivot = 0
    fun deserialize(): NestedInteger {
        val result = NestedInteger()
        if (ca[pivot] != '[') {
            var num = 0
            var mul = 1
            if (ca[pivot] == '-') {
                mul = -1
                pivot++
            }
            while (pivot != ca.size && ca[pivot].isDigit()) {
                num = num * 10 + (ca[pivot++] - '0')
            }
            result.setInteger(num * mul)
        } else {
            pivot++
            while (ca[pivot] != ']') {
                result.add(deserialize())
                if (ca[pivot] == ',') pivot++
            }
            pivot++
        }
        return result
    }
    return deserialize()
}