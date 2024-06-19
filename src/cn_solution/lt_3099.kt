package cn_solution

fun sumOfTheDigitsOfHarshadNumber(x: Int): Int {
    var sum = 0
    var y = x
    while (y != 0) {
        sum += y % 10
        y /= 10
    }
    return if (x % sum == 0) sum else -1
}