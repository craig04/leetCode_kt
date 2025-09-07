package cn_solution

fun makeTheIntegerZero(num1: Int, num2: Int): Int {
    var t = 1
    while (true) {
        val num = num1 - 1L * t * num2
        when {
            t > num -> return -1
            t >= num.countOneBits() -> return t
            else -> t++
        }
    }
}