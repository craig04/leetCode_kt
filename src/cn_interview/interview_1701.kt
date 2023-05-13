package cn_interview

fun add(a: Int, b: Int): Int {
    var result = a
    var c = b
    while (c != 0) {
        val carry = result and c shl 1
        result = result xor c
        c = carry
    }
    return result
}