package solution_cn

fun totalMoney(n: Int): Int {
    val w = n / 7
    val d = n % 7
    return w * 7 * (w + 7) / 2 + (1 + d) * d / 2 + w * d
}