package solution

fun totalMoney(n: Int): Int {
    val w = n / 7
    val d = n - w * 7
    return (w * (w + 7) * 7 + (2 * w + d + 1) * d) / 2
}