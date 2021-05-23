package solution_cn

fun decode(encoded: IntArray): IntArray {
    val n = encoded.size + 1
    val all = (1..n).reduce { acc, i -> acc xor i }
    val exp = (1 until n step 2).fold(0) { acc, i -> acc xor encoded[i] }
    val result = IntArray(n)
    result[0] = all xor exp
    for (i in 1 until n) {
        result[i] = result[i - 1] xor encoded[i - 1]
    }
    return result
}