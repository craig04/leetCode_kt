package cn_solution

fun circularPermutation(n: Int, start: Int): List<Int> {
    return IntArray(1 shl n) { it.xor(it / 2).xor(start) }.asList()
}