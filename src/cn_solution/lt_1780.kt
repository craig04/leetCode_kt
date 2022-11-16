package cn_solution

fun checkPowersOfThree(n: Int): Boolean {
    var temp = n
    while (temp != 0) {
        if (temp % 3 == 2)
            return false
        temp /= 3
    }
    return true
}
