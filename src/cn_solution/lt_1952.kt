package cn_solution

fun isThree(n: Int): Boolean {
    var i = 2
    while (i * i < n)
        if (n % i++ == 0)
            return false
    return i * i == n
}