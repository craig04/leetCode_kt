package cn_solution

fun sumOfMultiples(n: Int): Int {
    fun sum(x: Int) = (n / x).let { (x + it * x) * it / 2 }
    return sum(3) + sum(5) + sum(7) - sum(15) - sum(21) - sum(35) + sum(105)
}
