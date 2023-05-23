package cn_interview

fun reverseBits(num: Int): Int {
    var one = 0
    var longest = 0
    return (0 until 32).fold(0) { res, i ->
        if (1 shl i and num != 0) {
            longest++
            one++
        } else {
            longest = one + 1
            one = 0
        }
        maxOf(res, longest)
    }
}