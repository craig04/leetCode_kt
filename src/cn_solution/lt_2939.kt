package cn_solution

fun maximumXorProduct(a: Long, b: Long, n: Int): Int {
    val mask = 1L.shl(n) - 1
    val diff = a.xor(b).and(mask)
    val same = diff.xor(mask)
    val x = mask.inv().and(a)
    val y = mask.inv().and(b)
    if (x != y) {
        return multiply(maxOf(x, y).or(same), minOf(x, y).or(same).or(diff))
    }
    val high = diff.takeHighestOneBit()
    return multiply(x.or(same).or(high), y.or(same).or(diff.xor(high)))
}

private fun multiply(x: Long, y: Long): Int {
    val mod = 1000000007
    return (((x % mod) * (y % mod)) % mod).toInt()
}