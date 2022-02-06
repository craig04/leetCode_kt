package solution_cn

fun integerReplacement(n: Int): Int {
    var m = n
    var count = 0
    while (m != 1) {
        if (m % 2 == 0) {
            count++
            m /= 2
        } else if (m % 4 == 1) {
            count += 2
            m /= 2
        } else if (m == 3) {
            count += 2
            m = 1
        } else {
            count += 2
            m = m / 2 + 1
        }
    }
    return count
}

fun integerReplacement_shorter(n: Int): Int {
    var m = n
    var count = 0
    while (m > 3) {
        count += 1 + (m and 3 and 1)
        m = m / 2 + (m and 3) / 3
    }
    return count + m - 1
}