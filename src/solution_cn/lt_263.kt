package solution_cn

fun isUgly(n: Int): Boolean {
    if (n == 0) {
        return false
    }
    var temp = n
    for (i in intArrayOf(2, 3, 5)) {
        while (temp % i == 0) {
            temp /= i
        }
    }
    return temp == 1
}