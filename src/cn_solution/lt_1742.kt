package cn_solution

fun countBalls(lowLimit: Int, highLimit: Int): Int {
    return (lowLimit..highLimit).groupingBy {
        var sum = 0
        var temp = it
        while (temp != 0) {
            sum += temp % 10
            temp /= 10
        }
        sum
    }.eachCount().maxOf { it.value }
}
