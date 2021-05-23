package solution_cn

fun reverse(x: Int): Int {
    var temp = x
    var result = 0
    while (temp != 0) {
        if (result < Int.MIN_VALUE / 10 || result > Int.MAX_VALUE / 10) {
            return 0
        }
        result = result * 10 + temp % 10
        temp /= 10
    }
    return result
}