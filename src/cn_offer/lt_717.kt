package cn_offer

fun isOneBitCharacter(bits: IntArray): Boolean {
    var i = 0
    while (i < bits.size - 1) {
        i += bits[i] + 1
    }
    return i == bits.size - 1
}