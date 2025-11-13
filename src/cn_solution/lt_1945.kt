package cn_solution

fun getLucky(s: String, k: Int): Int {
    var sum = 0
    for (c in s) {
        val t = c - 'a' + 1
        sum += t / 10 + t % 10
    }
    for (i in 1 until k) {
        if (sum < 10)
            break
        var tmp = 0
        while (sum != 0) {
            tmp += sum % 10
            sum /= 10
        }
        sum = tmp
    }
    return sum
}