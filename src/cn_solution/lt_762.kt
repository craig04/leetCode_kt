package cn_solution

fun countPrimeSetBits(left: Int, right: Int): Int {
    val mask = arrayOf(2, 3, 5, 7, 11, 13, 17, 19).fold(0) { m, t -> 1 shl t or m }
    return (left..right).count { 1 shl Integer.bitCount(it) and mask != 0 }
}