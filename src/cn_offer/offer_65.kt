package cn_offer

fun add(a: Int, b: Int): Int {
    var x = a
    var y = b
    while (y != 0) {
        val z = x and y shl 1
        x = x xor y
        y = z
    }
    return x
}