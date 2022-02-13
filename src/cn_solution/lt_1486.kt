package cn_solution

fun xorOperation(n: Int, start: Int): Int {
    fun sumXor(n: Int): Int {
        return when (n % 4) {
            0 -> n
            1 -> 1
            2 -> n + 1
            else -> 0
        }
    }

    val s = start shr 1
    val e = n and start and 1
    return sumXor(s - 1) xor sumXor(s + n - 1) shl 1 xor e
}