package cn_solution

fun maximumRows(matrix: Array<IntArray>, numSelect: Int): Int {
    val bits = IntArray(matrix.size) {
        matrix[it].fold(0) { acc, i -> acc shl 1 or i }
    }
    var result = 0
    val limit = 1.shl(matrix[0].size)
    var mask = 1.shl(numSelect) - 1
    while (mask < limit) {
        result = maxOf(result, bits.count { it and mask == it })
        val head = mask + mask.takeLowestOneBit()
        val tail = head xor mask shr (mask.countTrailingZeroBits() + 2)
        mask = head or tail
    }
    return result
}