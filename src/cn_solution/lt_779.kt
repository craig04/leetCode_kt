package cn_solution

fun kthGrammar(n: Int, k: Int): Int {
    if (n == 1)
        return 0
    val pre = kthGrammar(n - 1, (k + 1) / 2)
    return 1 - k.and(1).xor(pre)
}