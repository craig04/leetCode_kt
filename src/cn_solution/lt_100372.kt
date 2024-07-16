package cn_solution

fun minChanges(n: Int, k: Int): Int {
    return if (n or k != n) -1 else n.xor(k).countOneBits()
}