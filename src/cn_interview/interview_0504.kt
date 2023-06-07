package cn_interview

fun findClosedNumbers(num: Int): IntArray {
    var bit = 1
    var one = 0
    var zero = 0
    var up = -1
    var low = -1
    for (i in 0 until 30) {
        if (bit.and(num) != 0) {
            if (up == -1 && bit.shl(1).and(num) == 0) {
                up = bit.shl(1).or(num)
                up = (bit.shl(1) - 1).inv().and(up)
                up = (1.shl(one) - 1).or(up)
            }
            one++
        } else {
            if (low == -1 && bit.shl(1).and(num) != 0) {
                low = bit.shl(1).inv().and(num)
                low = (bit.shl(1) - 1).or(low)
                low = (1.shl(zero) - 1).inv().and(low)
            }
            zero++
        }
        bit = bit.shl(1)
    }
    return intArrayOf(up, low)
}