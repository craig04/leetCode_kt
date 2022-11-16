package cn_solution

fun maximumScore(a: Int, b: Int, c: Int): Int {
    val sum = a + b + c
    val max = maxOf(a, b, c)
    return (sum - maxOf(max * 2 - sum, 0)) / 2
}
