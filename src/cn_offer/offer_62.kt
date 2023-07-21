package cn_offer

fun lastRemaining(n: Int, m: Int): Int {
    return (2..n).fold(0) { pos, i -> (pos + m) % i }
}