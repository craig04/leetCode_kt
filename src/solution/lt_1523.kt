package solution

fun countOdds(low: Int, high: Int): Int {
    return (high + 1).shr(1) - low.shr(1)
}