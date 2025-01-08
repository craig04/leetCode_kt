package cn_solution

fun decrypt(code: IntArray, k: Int): IntArray {
    val n = code.size
    return IntArray(n, when {
        k > 0 -> { i -> (i + 1..i + k).sumOf { code[it % n] } }
        k < 0 -> { i -> (i + k..i - 1).sumOf { code[(it + n) % n] } }
        else -> { _ -> 0 }
    })
}
