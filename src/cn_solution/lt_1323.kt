package cn_solution

fun maximum69Number(num: Int): Int {
    var max = 0
    var pow = 1
    var tmp = num
    while (tmp != 0) {
        val mod = tmp % 10
        if (mod == 6)
            max = pow
        pow *= 10
        tmp /= 10
    }
    return num + max * 3
}