package solution

fun countBalls(lowLimit: Int, highLimit: Int): Int {
    return (lowLimit..highLimit).groupBy {
        var sum = 0
        var temp = it
        while (temp != 0) {
            sum += temp % 10
            temp /= 10
        }
        sum
    }.values.maxBy { it.size }.size
}
