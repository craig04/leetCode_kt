package cn_solution

fun checkPerfectNumber(num: Int): Boolean {
    if (num == 1)
        return false
    var i = 2
    var sum = 1
    while (i * i < num) {
        if (num % i == 0)
            sum += i + num / i
        i++
    }
    if (i * i == num)
        sum += i
    return sum == num
}