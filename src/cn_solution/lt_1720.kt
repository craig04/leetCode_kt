package cn_solution

fun decode(encoded: IntArray, first: Int): IntArray {
    val result = IntArray(encoded.size + 1)
    result[0] = first
    encoded.indices.forEach {
        result[it + 1] = result[it] xor encoded[it]
    }
    return result
}