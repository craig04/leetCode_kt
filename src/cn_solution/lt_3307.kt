package cn_solution

fun kthCharacter(k: Long, operations: IntArray): Char {
    return 'a' + (0 until minOf(64, operations.size)).count {
        1L.shl(it).and(k) != 0L && operations[it] == 1
    } % 26
}